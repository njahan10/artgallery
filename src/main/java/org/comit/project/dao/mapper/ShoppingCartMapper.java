package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.project.bean.Art;
import org.comit.project.bean.Role;
import org.comit.project.bean.ShoppingCart;
import org.comit.project.bean.User;
import org.springframework.jdbc.core.RowMapper;



public class ShoppingCartMapper implements RowMapper<ShoppingCart> {

	@Override
	public ShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {

		ShoppingCart shoppingCart  = new ShoppingCart();

		shoppingCart.setId(rs.getInt("CART_ID"));
		shoppingCart.setQuantity(rs.getInt("QUANTITY"));
		shoppingCart.setDateAdded(rs.getDate("DATE_ADDED"));
		
		User user = new User();
		user.setId(rs.getInt("USER_ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setUserName(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setEmail(rs.getString("EMAIL"));
		user.setBirth(rs.getDate("BIRTH"));
		user.setStatus(rs.getString("STATUS"));
		
		Role role = new Role();
		role.setId(rs.getInt("ROLE_ID"));
        role.setRoleName(rs.getString("ROLE_NAME"));
        role.setRoleDesc(rs.getString("ROLE_DESC"));
        role.setStatus(rs.getString("STATUS"));
        user.setRole(role);
        
		Art art = new Art();
		art.setId(rs.getInt("ARTS_ID"));
		art.setTitle(rs.getString("ARTS_TITLE"));
		art.setSize(rs.getString("ARTS_SIZE"));
		art.setDescription(rs.getString("ARTS_DESCRIPTION"));
		art.setPrice(rs.getDouble("ARTS_PRICE"));
		art.setImageName(rs.getString("ARTS_IMAGE_NAME"));
		art.setImageUUID(rs.getString("ARTS_IMAGE_UUID"));
        
        shoppingCart.setUser(user);
        shoppingCart.setArt(art);
        

		return shoppingCart;
	}
}