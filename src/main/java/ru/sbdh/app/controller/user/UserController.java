package ru.sbdh.app.controller.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.factory.UserFactory;
import ru.sbdh.app.mapper.UserMapper;
import ru.sbdh.app.models.User;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Inject
    @Qualifier("userFactory")
    UserFactory userFactory;

    @RequestMapping("getbyid")
    public User getUserById(@RequestParam(value = "id", defaultValue = "5") Integer id) {
        return userFactory.getUserById(id);
    }

    @RequestMapping("getall")
    public List<User> getAllUsers() {
        return userFactory.getAllUsers();
    }

}