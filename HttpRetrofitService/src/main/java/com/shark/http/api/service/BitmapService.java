package com.shark.http.api.service;

import android.util.Log;

import com.shark.http.api.core.BaseApiService;
import com.shark.retrofit.http.core.HttpManager;
import com.shark.retrofit.http.header.IUserAgent;
import com.soaringcloud.kit.box.LogKit;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by renyuxiang on 2017/5/17.
 */

public class BitmapService extends BaseApiService {
    private BitmapApi bitmapApi;

    public BitmapService(IUserAgent userAgent) {
        bitmapApi = HttpManager.getInstance(getServerBaseUrl(), userAgent)
                .createAPI(BitmapApi.class);
    }

    public void getEmojisAsync(Callback<Example> callback) {
        bitmapApi.getEmojis().enqueue(callback);
    }

    public Response<Example> getEmojisSync() {
        try {
            return bitmapApi.getEmojis().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getGistsAsync(String gistId) {
        bitmapApi.getUsers(gistId);
    }
}
