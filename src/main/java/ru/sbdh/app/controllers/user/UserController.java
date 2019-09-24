package ru.sbdh.app.controllers.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.dao.mapper.UserMapper;
import ru.sbdh.app.models.User;

import javax.inject.Inject;
import java.util.List;

@RestController
public class UserController {
    /**
     * This one performs batched upsert operations
     */
//    @Inject
//    BatchUpsertFlatObjectDAO batchFlatObjectDAO;

    /**
     * This one performs upsert operations iteratively
     */
    @Inject
    @Qualifier("userMapper")
    UserMapper userMapper;

    @RequestMapping("/user/getbyid")
    public User getuserbyid(@RequestParam(value = "id", defaultValue = "World") Integer id) {
        User user = userMapper.getUserById(id).get(0);
        return user;
    }

    @RequestMapping("/user/getall")
    public List<User> getallusers() {
        List<User> user = userMapper.getAllUser();
        return user;
    }
}