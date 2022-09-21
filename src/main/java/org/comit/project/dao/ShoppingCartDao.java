package org.comit.project.dao;
import java.util.List;

import org.comit.project.bean.ShoppingCart;
import org.comit.project.dao.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ShoppingCartDao {
    
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ShoppingCart> listItems(long userId){
    	String sql = "SELECT SC.*, U.*, R.*, A.* FROM SHOPPING_CARTS SC "
    			+ "LEFT JOIN USERS U ON SC.USER_ID = U.USER_ID "
    			+ "LEFT JOIN USERS_ROLES UR ON U.USER_ID = UR.USER_ID "
    			+ "LEFT JOIN ROLES R ON UR.ROLE_ID = R.ROLE_ID "
    			+ "LEFT JOIN ARTS A ON SC.ARTS_ID = A.ARTS_ID "
    			+ "WHERE U.USER_ID = ?";
		return jdbcTemplate.query(sql, new ShoppingCartMapper(), userId);	
	}
	
	public void removeItem(long shoppingcartId){
    	String sql = "DELETE FROM SHOPPING_CARTS WHERE CART_ID = ?";
		jdbcTemplate.update(sql,new Object[] {shoppingcartId});
	}
	
	public void addItem(long artId, long userId, int quantity){
    	String sql = "INSERT INTO SHOPPING_CARTS (ARTS_ID, QUANTITY,USER_ID) VALUES(?,?,?)";
		jdbcTemplate.update(sql,new Object[] {artId, quantity, userId});
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

