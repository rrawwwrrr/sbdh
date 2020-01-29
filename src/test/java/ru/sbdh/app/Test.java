package ru.sbdh.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sbdh.app.models.UserModel;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testistest() {
        String jsonString;
//         jsonString = "{\"id\":11,\"fio\":92,\"ncbn\":\"107\",\"nphn\":\"\",\"nphn2\":\"700035\",\"newphone\":\"31\",\"ip\":\"192.168.2.111\",\"mac\":null,\"dolj\":\"Документовед\",\"otdel\":9,\"used\":true,\"tmpname\":\"Файзуллина Эльмира Дулфатовна\",\"tmpmac\":null,\"find\":true,\"call\":true}" ;
         jsonString = "[{\"id\": 39, \"dolj\": \"Начальник отдела\"}, {\"id\": 38, \"dolj\": \"ведущий специалист по работе службы кладбищ\"}, {\"id\": 36, \"dolj\": \"Заместитель начальника отдела\"}, {\"id\": 37, \"dolj\": \"Специалист по работе службы администрации кладбищ 1 кат.\"}]";
//        jsonString = "{\"id\": 39, \"dolj\": \"Начальник отдела\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<UserModel> user = Arrays.asList(mapper.readValue(jsonString, UserModel[].class));
            System.out.println(user);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
