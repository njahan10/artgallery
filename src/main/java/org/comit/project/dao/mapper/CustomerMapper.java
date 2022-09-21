package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.comit.project.bean.Customer;
import org.springframework.jdbc.core.RowMapper;


public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer customer = new Customer();

		customer.setId(rs.getInt("Customer_Id"));
		customer.setFirstname(rs.getString("First_Name"));
		customer.setLastname(rs.getString("Last_Name"));
		customer.setEmail(rs.getString("Email"));
		customer.setPassword(rs.getString("Password"));
		customer.setAddress(rs.getString("Address"));
	
		return customer ;
	}

}