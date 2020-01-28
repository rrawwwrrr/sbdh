package ru.sbdh.app.dao.mapper;

import org.apache.ibatis.annotations.Select;
import ru.sbdh.app.models.ContractModel;

import java.util.List;

public interface ContractMapper {

   /* @Results(id = "user", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "fio", column = "fio"),
            @Result(property = "dolj", column = "dolj")
    })
    @Select("SELECT * FROM tmpcontract.userfull WHERE id = #{id}")
    List<UserModel> getContractById(Integer id);*/

    /*    @Results(id = "contractModel", value = {
                @Result(property = "id", column = "id", id = true),
                @Result(property = "used", column = "used"),
                @Result(property = "dolj", column = "dolj")
        })*/
    @Select("SELECT * FROM tmpcontract.uip order by id desc")
    List<ContractModel> getAllContracts();

    @Select("SELECT * FROM tmpcontract.uip where year = ${year} order by id desc")
    List<ContractModel> getContractsByYear(Integer year);
}
