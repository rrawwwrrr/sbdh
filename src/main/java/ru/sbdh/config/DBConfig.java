package ru.sbdh.config;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import ru.sbdh.mappers.user.UserMapper;

import javax.sql.DataSource;

public class DBConfig {
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.username}")
    private static String username;
    @Value("${spring.datasource.password}")
    private static String password;
    @Value("${spring.datasource.driver-class-name}")
    private static String driver;
    @Value("${spring.datasource.environment}")
    private static String env;

    private static SqlSessionFactory instance;

    private DBConfig() {
        //
    }

    public static synchronized SqlSessionFactory getInstance() {
        if (instance == null) {
            DataSource dataSource = getDataSource();
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment(env, transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(UserMapper.class);
            instance = new SqlSessionFactoryBuilder().build(configuration);
        }
        return instance;
    }

    public static DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        dataSourceBuilder.url(url);
        return dataSourceBuilder.build();
    }


}
