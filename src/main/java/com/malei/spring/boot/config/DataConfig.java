package com.malei.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.malei.spring.boot.config")
@EnableJpaRepositories("com.malei.spring.boot.repository")
public class DataConfig {
/*
    private static final String DB_DRIVER = "db.driver";
    private static final String DB_USER_NAME = "db.username";
    private static final String DB_URL = "db.url";
    private static final String DB_PASSWORD = "db.password";
    private static final String HB_DIALECT = "hibernate.dialect";
    private static final String HB_SHOW_SQL = "hibernate.show_sql";
    private static final String HB_HBM2DLL_AUTO = "hibernate.hbm2ddl.auto";

*/

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }
    /*Actually FactoryBean + JavaConfig has a
    proxy issue and it isn't recommended to use getObject() dirrectly at all, e
    specially on bean configuration phase. As a trick: use the result of FactoryBean as a
    bean-method parameter and autowire processor does the stuff for you.*/
    @Bean
    public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory){
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("com.malei.spring.boot.model");
        entityManagerFactory.setJpaProperties(jpaProperties());

        return entityManagerFactory;
    }

    private Properties jpaProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",env.getProperty("db.hibernate.dialect"));
        properties.put("hibernate.show_sql",env.getProperty("db.hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto",env.getProperty("db.hibernate.hbm2ddl.auto"));

        return properties;
    }
}
