package ru.sbdh.app.dao.mapper;


import org.apache.ibatis.annotations.*;
import ru.sbdh.app.models.UserModel;

import java.util.List;

/**
 * @author Harshit Aggarwal
 */
public interface UserMapper {

    @Results(id = "user",value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "fio", column = "fio"),
            @Result(property = "dolj", column = "dolj")
    })
    @Select("SELECT * FROM userfull WHERE id = #{id}")
    List<UserModel> getUserById(Integer id);

    @ResultMap("user")
    @Select("SELECT * FROM userfull order by id")
    List<UserModel> getAllUser();


}
