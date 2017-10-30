package com.shark.retrofit.http.core;


import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


/**
 * Created by renyuxiang on 2015/12/3.
 */
public abstract class HttpManager {
    private Retrofit retrofit;
    private Context context;
    private String baseUrl;

    public HttpManager(Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    public OkHttpClient.Builder getHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024/*10MB*/));
        return builder;
    }

    public Retrofit.Builder getRetrofitBuilder(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(getBaseUrl());
    }

    public <S> S createAPI(Class<S> apiClass) {
        if (retrofit == null) {
            reset();
        }
        return retrofit.create(apiClass);
    }

    public void reset() {
        retrofit = getRetrofitBuilder(getHttpClientBuilder().build()).build();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Context getContext() {
        return context;
    }
}
