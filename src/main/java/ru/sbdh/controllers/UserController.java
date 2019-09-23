package ru.sbdh.controllers;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.config.DBConfig;
import ru.sbdh.mappers.user.UserMapper;
import ru.sbdh.models.User;

@RestController
public class UserController {
//    @Autowired
//    UserMapper userMapper;
    @RequestMapping("/greeting")
    public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        SqlSessionFactory sqlSessionFactory = DBConfig.getInstance();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getArticle(6);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}