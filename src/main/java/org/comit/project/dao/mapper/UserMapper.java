package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.comit.project.bean.Art;
import org.comit.project.bean.Role;
import org.comit.project.bean.User;
import org.springframework.jdbc.core.RowMapper;


public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

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
        
		return user;
	}
}