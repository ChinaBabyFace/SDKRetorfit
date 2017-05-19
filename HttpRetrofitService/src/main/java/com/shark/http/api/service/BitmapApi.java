package com.shark.http.api.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by renyuxiang on 2017/5/17.
 */

public interface BitmapApi {
    /**
     * 无参数GET请求
     *
     * @return
     */
    @GET("emojis")
    Call<Example> getEmojis();


    /**
     * @param gistId
     * @return
     */
    @GET("gists")
    Call<Example> getUsers(@Query("{gist_id}") String gistId);
}
