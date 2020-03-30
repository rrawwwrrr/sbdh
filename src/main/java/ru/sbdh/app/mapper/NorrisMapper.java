package ru.sbdh.app.mapper;

import org.apache.ibatis.annotations.Select;
import ru.sbdh.app.models.NorrisModel;

import java.util.List;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
public interface NorrisMapper {
    @Select("SELECT  " +
            "  uu.id,uu.comment,uu.used,  uo.name as objectfull,uc.type,uu.created_at,  " +
            "  uc.NAME AS contractfull,  " +
            "  auth_id || '/' || hash || '/' || fileupload as files,  " +
            "  ( SELECT NAME FROM norris.isppodrs isp WHERE isp.ID = isppodrs_id ) AS isppodr   " +
            "FROM  " +
            "  norris.upl_uploads uu  " +
            "  LEFT JOIN norris.upl_contracts uc ON uu.upl_contracts_id = uc.ID  " +
            "  LEFT JOIN norris.upl_objects uo ON uu.upl_objects_id = uo.ID")
    List<NorrisModel> getAll();
}
