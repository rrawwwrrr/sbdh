package ru.sbdh.app.mapper;

import org.apache.ibatis.annotations.Select;
import ru.sbdh.app.models.NewsModel;


public interface NewsMapper {
    @Select("SELECT * FROM personal.news where id = ${id} limit 1")
    NewsModel getNew(String id);
}
