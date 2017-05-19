package com.shark.retrofit.http.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by renyuxiang on 2015/12/3.
 */
public class HeaderInterceptor implements Interceptor {
    private String userAgent;

    public HeaderInterceptor() {
    }

    public HeaderInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .header("User-Agent", userAgent)
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}
