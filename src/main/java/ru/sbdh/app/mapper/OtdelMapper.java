package ru.sbdh.app.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.sbdh.app.models.Otdel;

import java.util.List;

public interface OtdelMapper {

    @Results(id = "otdel", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "nameotdel", column = "nameotdel"),
            @Result(property = "nomenk", column = "fullname"),
            @Result(property = "email", column = "email"),
            @Result(property = "users", column = "users")
    })
    @Select("SELECT * FROM otdel WHERE id = #{id}")
    List<Otdel> getOtdelById(Integer id);

    @ResultMap("otdel")
    @Select("SELECT * from otdel;")
    List<Otdel> getAllOtdels();

    @ResultMap("otdel")
    @Select("select o.id,o.email,o.nameotdel,json_agg(u.*) as users from otdel o left join (userfull left join userss on userss.id=userfull.fio) as u on u.otdel= o.id  group by o.id,o.nameotdel order by nomenk ")
    List<Otdel> getAllOtdelsWithUsers();

}
