package com.shark.retrofit.http.core;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.shark.retrofit.http.header.IUserAgent;
import com.shark.retrofit.http.interceptor.HeaderInterceptor;
import com.shark.retrofit.http.interceptor.LogInterceptor;
import com.soaringcloud.kit.box.LogKit;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by renyuxiang on 2015/12/3.
 */
public class HttpManager {
    private Context context;
    private Retrofit retrofit;
    private OkHttpClient httpClient;
    private LogInterceptor logInterceptor;
    private HeaderInterceptor headerInterceptor;
    private String apiBaseUrl;

    private static volatile HttpManager ourInstance = null;

    public static HttpManager getInstance(String apiBaseUrl, IUserAgent userAgent) {
        if (ourInstance == null) {
            synchronized (HttpManager.class) {
                if (ourInstance == null) {
                    ourInstance = new HttpManager(apiBaseUrl, userAgent);
                }
            }
        }
        return ourInstance;
    }

    private HttpManager(String apiBaseUrl, IUserAgent userAgent) {
        this.apiBaseUrl = apiBaseUrl;
        this.context = userAgent.getContext();
        this.initHttpClient(userAgent);
        this.initRetrofit();
    }

    private void initHttpClient(IUserAgent userAgent) {
        //日志拦截器一定放在最后，否则输出可能不全
        headerInterceptor = new HeaderInterceptor(userAgent.generateUA());
        logInterceptor = new LogInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024/*10MB*/))
                .addInterceptor(headerInterceptor)
                .addInterceptor(logInterceptor);

        httpClient = builder.build();
    }

    private void initRetrofit() {
        LogKit.e(this, "initRetrofit:" + apiBaseUrl);

        retrofit = new Retrofit.Builder()
                .baseUrl(apiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    public <S> S createAPI(Class<S> apiClass) {
        return retrofit.create(apiClass);
    }

    public Retrofit getCore() {
        return retrofit;
    }
}
