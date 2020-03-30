package ru.sbdh.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Request;
import com.unboundid.util.json.JSONException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import ru.sbdh.app.common.Rest;
import ru.sbdh.app.models.UserModel;
import ru.sbdh.app.models.yandex.UserYandex;
import ru.sbdh.app.models.yandex.usermodel.UserResult;

import java.io.IOException;
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

    @org.junit.Test
    public void testOkHttp() throws IOException, JSONException {
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("https://api.directory.yandex.net/v6/users/?fields=name,gender,position,contacts")
                .addHeader("Authorization", " OAuth AgAAAAAEpF29AAYb5bPD15civU2mjWSBIm7G8Hc")
                .addHeader("Accept", " application/json")
                .build();
        String result = Rest.httpClient(request);
        UserYandex entity = objectMapper.readValue(result, UserYandex.class);
        UserResult r = entity.getResult().get(0);
        System.out.println("123");


    }
}
