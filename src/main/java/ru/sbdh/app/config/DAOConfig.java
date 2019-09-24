package ru.sbdh.app.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.sbdh.app.dao.mapper.FlatObjectMapper;

/**
 * This class holds custom bean definitions
 *
 * @author Harshit Aggarwal
 */
@Configuration
public class DAOConfig {

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(final SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public SqlSessionTemplate batchSqlSessionTemplate(final SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
    }

    @Bean(name = "flatObjectMapper")
    public MapperFactoryBean flatObjectMapper(final SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean mapper = new MapperFactoryBean();
        mapper.setMapperInterface(FlatObjectMapper.class);
        mapper.setSqlSessionTemplate(sqlSessionTemplate(sqlSessionFactory));
        return mapper;
    }


    @Bean(name = "batchFlatObjectMapper")
    public MapperFactoryBean batchFlatObjectMapper(final SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean mapper = new MapperFactoryBean();
        mapper.setMapperInterface(FlatObjectMapper.class);
        mapper.setSqlSessionTemplate(batchSqlSessionTemplate(sqlSessionFactory));
        return mapper;
    }


}
