package com.example.CustomerList.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CustomerList.CustomerListApplication;
import com.example.CustomerList.domain.Customer;
import com.example.CustomerList.domain.CustomerJDBC;


@Controller
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerListApplication.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    CustomerJDBC cjdbc;
       
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customerlist(Model model){
    	
    	log.info("Querying for customer records:");
        jdbcTemplate.query(
                "SELECT id, firstName, lastName FROM customer",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"))
        ).forEach(customer -> log.info(customer.toString()));
    	
        model.addAttribute("customers", cjdbc.findAll());
        return "customers";
    }
	
}