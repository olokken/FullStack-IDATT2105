package com.fullStack.DAO;

import javax.sql.DataSource;

public class test {
    public static void main(String[] args) {
        DataSource dt = SpringJdbcConfig.mysqlDataSource();
    }
}
