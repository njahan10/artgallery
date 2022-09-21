package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comit.project.bean.Role;
import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {

		Role role = new Role();

		role.setId(rs.getInt("ROLE_ID"));
		role.setRoleName(rs.getString("ROLE_NAME"));
		role.setRoleDesc(rs.getString("ROLE_DESC"));
		role.setStatus(rs.getString("STATUS"));

		return role;
	}

}