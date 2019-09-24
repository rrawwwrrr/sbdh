package ru.sbdh.app.dao.mapper;

import org.apache.ibatis.annotations.*;
import ru.sbdh.app.models.FlatObject;

import java.util.List;

/**
 * @author Harshit Aggarwal
 */
public interface FlatObjectMapper {

    @Results(id = "flatObject",value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "strAttr1", column = "str_attr1"),
            @Result(property = "strAttr2", column = "str_attr2"),
            @Result(property = "intAttr1", column = "int_attr1"),
            @Result(property = "intAttr2", column = "int_attr2"),
            @Result(property = "longAttr1", column = "long_attr1"),
            @Result(property = "longAttr2", column = "long_attr2"),
            @Result(property = "doubleAttr1", column = "double_attr1"),
            @Result(property = "doubleAttr2", column = "double_attr2"),
            @Result(property = "bigDecimalAttr1", column = "bigdecimal_attr1"),
            @Result(property = "bigDecimalAttr2", column = "bigdecimal_attr2"),
            @Result(property = "dateAttr1", column = "date_attr1"),
            @Result(property = "dateAttr2", column = "date_attr2")
    })
    @Select("SELECT * FROM flat_table WHERE id = #{id}")
    FlatObject getDataById(Long id);

    @ResultMap("flatObject")
    @Select("SELECT * FROM flat_table")
    List<FlatObject> getAllData();

    /**
     * Inserts given record in database, updates autogenerated id in the input java POJO
     * @return: # records updated
     */
    @Insert("INSERT INTO flat_table" +
               "(str_attr1 ,str_attr2 ,int_attr1 ,int_attr2 ,long_attr1 ,long_attr2 ," +
               "double_attr1 ,double_attr2,bigdecimal_attr1, bigdecimal_attr2 ,date_attr1 ,date_attr2)" +
            "VALUES (#{strAttr1},#{strAttr2},#{intAttr1},#{intAttr2},#{longAttr1}," +
                    "#{longAttr2},#{doubleAttr1},#{doubleAttr2},#{bigDecimalAttr1}," +
                    "#{bigDecimalAttr2},#{dateAttr1},#{dateAttr2}) ")
    @SelectKey(statement = "SELECT LASTVAL();", keyProperty = "id", keyColumn = "id", before = false, resultType = Long.class)
    long insertData(FlatObject flatObject);

    @Delete("DELETE FROM flat_table where id = #{id}")
    void deleteDataById(Long id);

    @Flush
    List flush();
}
