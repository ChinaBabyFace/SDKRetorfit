package com.shark.retrofit.http.interceptor;

import com.soaringcloud.kit.box.LogKit;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * <b>LogInterceptor。</b>
 * <p><b>详细说明：</b></p>
 * <!-- 在此添加详细说明 -->
 * 无。
 * <p><b>修改列表：</b></p>
 * <table width="100%" cellSpacing=1 cellPadding=3 border=1>
 * <tr bgcolor="#CCCCFF"><td>序号</td><td>作者</td><td>修改日期</td><td>修改内容</td></tr>
 * <!-- 在此添加修改列表，参考第一行内容 -->
 * <tr><td>1</td><td>Renyuxiang</td><td>2015/12/3</td><td>建立类型,实现功能</td></tr>
 * <p/>
 * </table>
 *
 * @author Renyuxiang
 * @version 1.0
 * @since 1.0
 */
public class LogInterceptor implements Interceptor {
    public static final int SYSTEM_PRINT = 0;
    public static final int LOG_PRINT = 1;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private int printType;

    public LogInterceptor(int printType) {
        this.printType = printType;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        println("=========================================================");
        println("REQUEST URL:" + request.url());
        println("REQUEST MTH:" + request.method());

        //输出POST请求的参数
        if (request.body() instanceof FormBody) {
            String formBodyString = "\n";
            FormBody formBody = (FormBody) request.body();
            for (int i = 0; i < formBody.size(); i++) {
                if (i > 0) formBodyString += "\n";
                formBodyString += "> " + formBody.encodedName(i);
                formBodyString += " = ";
                formBodyString += formBody.encodedValue(i);
            }
            println("REQUEST BDY:" + formBodyString);
        }

        println("=========================================================");

        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        ResponseBody responseBody = response.body();

        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        if (response != null) {
            println("HTTP COAST TM:" + tookMs);
            println("HTTP PROTOCOL:" + response.protocol());
            println("HTTP RES CODE:" + response.code());
            println("HTTP   RESULT:" + (response.isSuccessful() ? "Request successful!" : "Request fail!"));
        }
        if (responseBody.contentLength() != 0) {
            println("HTTP RESPONSE:\n" + buffer.clone().readString(charset));
        } else {
            println("HTTP RESPONSE:NO CONTENT");
        }
        println("=========================================================");
        return response;
    }

    private void println(String message) {
        if (printType == 0) {
            System.out.println(message);
        } else {
            LogKit.e(this, message);
        }
    }
}
