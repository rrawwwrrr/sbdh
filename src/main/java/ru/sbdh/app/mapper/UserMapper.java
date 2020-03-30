package ru.sbdh.app.mapper;


import ru.sbdh.app.models.UserModel;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Harshit Aggarwal
 */
public interface UserMapper {

    @Select("SELECT * FROM userfull WHERE id = #{id}")
    List<UserModel> getUserById(Integer id);


    @Select("SELECT *," +
            "(select fio from personal.userss where personal.userss.id=personal.userfull.user_id) as fio, " +
            "(select email from personal.userss where personal.userss.id=personal.userfull.user_id) as email, " +
            "(select nameotdel from personal.otdel where personal.otdel.id=personal.userfull.otdel_id) as otdel " +
            "FROM personal.userfull order by id;")
    List<UserModel> getAllUsers();

 /*   @Select("SELECT * FROM userfull order by id")
    List<UserModel> getAllUsers();*/


}
