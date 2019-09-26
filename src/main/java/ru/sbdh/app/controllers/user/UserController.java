package ru.sbdh.app.controllers.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.dao.mapper.UserMapper;
import ru.sbdh.app.models.User;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Inject
    @Qualifier("userMapper")
    UserMapper userMapper;

    @RequestMapping(value = "getbyid", method = RequestMethod.GET)
    public User getuserbyid(@RequestParam(value = "id", defaultValue = "World") Integer id) {
        User user = userMapper.getUserById(id).get(0);
        return user;
    }

    @RequestMapping("getall")
    public List<User> getallusers() {
        List<User> user = userMapper.getAllUser();
        return user;
    }
    @RequestMapping(value = "getbydid", method = RequestMethod.GET)
    public User getuserbydid(@RequestParam(value = "id", defaultValue = "World") Integer id) {
        User user = userMapper.getUserById(id).get(0);
        return user;
    }
}