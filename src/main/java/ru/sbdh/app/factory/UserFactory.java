package ru.sbdh.app.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.sbdh.app.mapper.UserMapper;
import ru.sbdh.app.models.User;

import javax.inject.Inject;
import java.util.List;

@Component
public class UserFactory {
    @Inject
    @Qualifier("userMapper")
    UserMapper userMapper;


    public User getUserById(Integer id) {
        return userMapper.getUserById(id).get(0);
    }

    public List<User> getAllUsers() {
        List<User> user = userMapper.getAllUser();
        return user;
    }
}
