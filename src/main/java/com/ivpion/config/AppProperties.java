package com.ivpion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:etc/prop/application.properties")
public class AppProperties {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPass;
    @Value("${spring.jpa.show-sql}")
    private boolean showSql;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String jpaDdlAuto;
    @Value("${spring.jpa.properties.hibernate.dialect }")
    private String dbDialect;

    public AppProperties() {
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public String getJpaDdlAuto() {
        return jpaDdlAuto;
    }

    public String getDbDialect() {
        return dbDialect;
    }
}
