package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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

		return user;
	}

}