package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ZohoDataSourceConfig {

    @Bean(name = "zohoDataSource")
    public DataSource zohoDataSource() {
        return org.springframework.boot.jdbc.DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/zoho")
                .username("springstudent")
                .password("springstudent")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "zohoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean zohoEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("zohoDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.demo.zoho.entity")
                .persistenceUnit("zoho")
                .build();
    }

    @Bean(name = "zohoTransactionManager")
    public PlatformTransactionManager zohoTransactionManager(
            @Qualifier("zohoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
