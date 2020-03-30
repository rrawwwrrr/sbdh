package ru.sbdh.app.common;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Rest {
    public static String httpClient(Request request) throws IOException {

        return new OkHttpClient().newCall(request).execute().body().string();

    }

}
