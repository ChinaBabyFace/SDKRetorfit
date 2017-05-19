package com.shark.sdk.retorfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shark.http.api.service.BitmapService;
import com.shark.http.api.service.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BitmapService service=new BitmapService(new UserAgent(this));
        service.getEmojisAsync(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

//        service.getGistsAsync("127b9132be45e9a258008dd228cd6aa0");

    }
}
