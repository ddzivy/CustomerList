package com.example.CustomerList.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerJDBC {

	@Autowired
    JdbcTemplate template;

    public List<Customer> findAll() {
        String sql = "select * from customer";
        RowMapper<Customer> rm = new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            	Customer customer = new Customer(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"));
                return customer;
            }
        };

        return template.query(sql, rm);
	
}
}
