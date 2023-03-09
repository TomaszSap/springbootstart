package com.eazybytes.eazyschool.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
public class PersonDAOImpl  {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public  PersonDAOImpl(DataSource dataSource)
    {
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

}
