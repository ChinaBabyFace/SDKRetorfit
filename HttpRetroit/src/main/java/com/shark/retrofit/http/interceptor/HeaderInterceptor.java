package com.shark.retrofit.http.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by renyuxiang on 2015/12/3.
 */
public class HeaderInterceptor implements Interceptor {
    private HashMap<String, String> headerMap;

    public HeaderInterceptor(HashMap<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (headerMap == null || headerMap.size() == 0) {
            return chain.proceed(chain.request());
        }

        Request.Builder builder =  chain.request().newBuilder();
        for (Map.Entry<String, String> param : headerMap.entrySet()) {
            builder.addHeader(param.getKey(), param.getValue());
        }

        return chain.proceed(builder.build());
    }
}
