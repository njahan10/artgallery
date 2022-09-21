package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.Order;
import org.comit.project.bean.User;
import org.comit.project.dao.mapper.OrderMapper;
import org.comit.project.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDao {
    
	List<Order> orders;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Order> listOrders(){
    	String sql = "SELECT * FROM ORDERS";
		return jdbcTemplate.query(sql, new OrderMapper());	
	}
	public Order findOrder(int idOrder) {
		String sql="SELECT * FROM ORDER WHERE Order_Id=?";
		return jdbcTemplate.queryForObject(sql,new OrderMapper(), idOrder);
	}   
    public void deleteOrder(int idOrder) {
		String sql = "DELETE FROM ORDER WHERE Order_Id = ?";
        jdbcTemplate.update(sql,new Object[] {idOrder});
    }
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

