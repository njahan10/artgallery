package org.comit.project.dao;

import java.util.List;

import org.comit.project.bean.User;
import org.comit.project.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    
	List<User> users;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<User> listUsers(){
    	String sql = "SELECT * FROM USERS";
		return jdbcTemplate.query(sql, new UserMapper());	
	}
	public User findUser(int idUser) {
		String sql="SELECT * FROM USERS WHERE USER_ID=?";
		return jdbcTemplate.queryForObject(sql,new UserMapper(), idUser);
	}
    public User findByUsername(String username) {
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		List<User> users = jdbcTemplate.query(sql, new UserMapper(), username);
		return users.isEmpty()?null:users.get(0);
	}
	public void createUser(User user) {
    	String sql="INSERT INTO USERS(FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,EMAIL,BIRTH,STATUS)+ VALUES(???????)";    	
    	jdbcTemplate.update(sql,new Object[]{user.getFirstName(),user.getLastName(),user.getUserName(),user.getPassword(),
    	user.getEmail(), user.getBirth(),user.getStatus()});		
    	}
	public void modifyUser(User user) {
		String sql="UPDATE USERS SET USERNAME = ?, FIRST_NAME = ?, LAST_NAME = ?, BIRTH = ? " +"WHERE ID_USER = ?";
	    jdbcTemplate.update(sql,new Object[] {user.getUserName(), user.getFirstName(),
			                user.getLastName(), user.getBirth(), user.getId()});
	}

    public void deleteUser(int idUser) {

		String sql = "DELETE FROM USER WHERE ID_USER = ?";

        jdbcTemplate.update(sql,new Object[] {idUser});
    }
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

