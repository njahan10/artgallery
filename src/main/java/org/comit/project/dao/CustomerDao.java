package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.Customer;
import org.comit.project.dao.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDao {
    
	List<Customer> customers;
	
	JdbcTemplate jdbcTemplate;
	
	public List<Customer> listCustomer(){
    	String sql = "SELECT * FROM CUSTOMERS";
		return jdbcTemplate.query(sql, new CustomerMapper());	
	}
	public Customer findCustomer(int idCustomer) {
		String sql="SELECT * FROM CUSTOMERS WHERE Customer_Id=?";
		return jdbcTemplate.queryForObject(sql,new CustomerMapper(), idCustomer);
	}   
	public void createCustomer(Customer customer) {
    	String sql="INSERT INTO CUSTOMERS(First_Name,Last_Name,Email,Password,Address)+ VALUES(???????)";    	
    	jdbcTemplate.update(sql,new Object[]{customer.getFirstname(),customer.getLastname(),customer.getEmail(),customer.getPassword(),   
    	customer.getAddress()});		
    	}
	public void modifyCustomer(Customer customer) {
		String sql="UPDATE CUSTOMERS SET First_Name = ?, Last_Name = ?, Email = ? " +"WHERE Customer_Id = ?";
	    jdbcTemplate.update(sql,new Object[] {customer.getFirstname(),
			                customer.getLastname(), customer.getEmail(), customer.getId()});
	}

    public void deleteCustomer(int idCustomer) {

		String sql = "DELETE FROM USER WHERE Customer_Id = ?";

        jdbcTemplate.update(sql,new Object[] {idCustomer});
    }
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

