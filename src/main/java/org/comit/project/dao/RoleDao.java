package org.comit.project.dao;
import java.util.List;
import org.comit.project.bean.Role;
import org.comit.project.dao.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class RoleDao {
    
	List<Role> roles;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Role> listRoles(){
    	String sql = "SELECT * FROM ROLES";
		return jdbcTemplate.query(sql, new RoleMapper());	
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

