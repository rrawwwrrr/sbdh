package ru.sbdh.app.mapper;

import org.apache.ibatis.annotations.Select;
import ru.sbdh.app.models.KbkModel;

import java.util.List;

public interface KbkMapper {

    @Select("SELECT * FROM onec.data order by id desc")
    List<KbkModel> getAllKbk();

    @Select("select d.guid,d.name,sum(dl.summ),substring(d.value from '...$')as kvr,d.value,jsonb_agg((SELECT x FROM (SELECT summ,kosgu ) AS x)) as kosgu " +
            "from onec.data d " +
            "join onec.data_kbk dk on d.guid = dk.guid " +
            "left join onec.data_lbo dl on dl.guid = d.guid " +
            "where  ${year} = dl.year and used " +
            "and dl.year between dk.start_year and dk.finish_year " +
            "group by  d.value,d.guid,d.name")
    List<KbkModel> getKbkByYear(Integer year);
}
