package ru.sbdh.app.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.sbdh.app.models.UserModel;
import ru.sbdh.app.mapper.UserMapper;


import javax.inject.Inject;
import java.util.List;

@Component
public class UserFactory {
    @Inject
    @Qualifier("userMapper")
    UserMapper userMapper;


    public UserModel getUserById(Integer id) {
        return userMapper.getUserById(id).get(0);
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> user = userMapper.getAllUsers();
        return user;
    }
}
