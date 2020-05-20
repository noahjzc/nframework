package com.noah.nframework.core.configuration;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 10:14
 */
public class DatabaseConfiguration {
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcPassword;

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
