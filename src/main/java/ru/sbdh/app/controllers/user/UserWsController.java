package ru.sbdh.app.controllers.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import ru.sbdh.app.factory.UserFactory;
import ru.sbdh.app.models.UserModel;

import javax.inject.Inject;
import java.util.List;

@Controller
public class UserWsController {
    @Inject
    @Qualifier("userFactory")
    UserFactory userFactory;

    @SubscribeMapping("/topic/greetings")
    public UserModel hello() throws Exception {
        return userFactory.getAllUsers().get(0);
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public UserModel greeting(String message) throws Exception {
        return userFactory.getAllUsers().get(0);
    }
}
