package ru.sbdh.app.mapper;


import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.sbdh.app.models.User;

import java.util.List;

/**
 * @author Harshit Aggarwal
 */
public interface UserMapper {

    @Results(id = "user",value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "fullname", column = "fullname"),
            @Result(property = "dolj", column = "dolj")
    })
    @Select("SELECT * FROM userfull WHERE id = #{id}")
    List<User> getUserById(Integer id);

    @ResultMap("user")
    @Select("SELECT *,(select fio from userss where userss.id=userfull.fio) as fullname FROM userfull order by id;")
    List<User> getAllUser();


}
