package com.shark.http.api.core;

import com.shark.retrofit.http.core.HttpManager;
import com.shark.retrofit.http.header.IUserAgent;

/**
 * Created by renyuxiang on 2017/5/17.
 */

public abstract class BaseApiService {
    private String serverBaseUrl = "https://api.github.com/";

    public String getServerBaseUrl() {
        return serverBaseUrl;
    }
}
