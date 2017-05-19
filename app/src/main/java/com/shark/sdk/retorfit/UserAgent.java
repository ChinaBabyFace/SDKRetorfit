package com.shark.sdk.retorfit;

import android.content.Context;

import com.shark.retrofit.http.header.IUserAgent;

/**
 * Created by renyuxiang on 2017/5/17.
 */

public class UserAgent implements IUserAgent {
    private Context context;

    public UserAgent(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public String generateUA() {
        return "";
    }
}
