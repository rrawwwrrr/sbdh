package ru.sbdh.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import ru.sbdh.app.models.UserModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testistest() {
        String jsonString;
        jsonString = "[{\"id\": 39, \"dolj\": \"Начальник отдела\"}, {\"id\": 38, \"dolj\": \"ведущий специалист по работе службы кладбищ\"}, {\"id\": 36, \"dolj\": \"Заместитель начальника отдела\"}, {\"id\": 37, \"dolj\": \"Специалист по работе службы администрации кладбищ 1 кат.\"}]";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<UserModel> user = Arrays.asList(mapper.readValue(jsonString, UserModel[].class));
            System.out.println(user);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @org.junit.Test
    public void testHttp() throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://api.directory.yandex.net/v6/users");
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "OAuth AgAAAAAEpF29AAYb5bPD15civU2mjWSBIm7G8Hc");
//        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpGet.setHeader(HttpHeaders.ACCEPT, "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        HttpResponse res = response;
    }
}
