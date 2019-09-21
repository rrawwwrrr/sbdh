package ru.sbdh.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.sbdh.Article;

@Mapper
public interface ArticleMapper {
    @Select("SELECT dolj FROM userfull WHERE id = #{id}")
    Article getArticle(@Param("id") Long id);
}
