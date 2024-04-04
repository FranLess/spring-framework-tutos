package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.dao.IStudentDAO;
import com.example.dao.StudentDAOImp;

@Configuration
@ComponentScan(basePackages = { "com.example" })
@EnableTransactionManagement
public class JdbcAppConfig{

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(jdbcDataSource());
        return template;
    }

    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/school");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("jonjon123.");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(jdbcDataSource());
        return transactionManager;
    }

    @Bean
    public IStudentDAO studentDao() {
        return new StudentDAOImp();
    }

    public TransactionTemplate transactionTemplate() {
        TransactionTemplate template = new TransactionTemplate();
        return template;
    }
}
