package org.comit.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;

import org.comit.project.bean.User;
import org.comit.project.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    
	List<User> users;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<User> listUsers(){
    	String sql = "SELECT U.*, R.* FROM USERS U LEFT JOIN USERS_ROLES UR ON U.USER_ID = UR.USER_ID LEFT JOIN ROLES R ON UR.ROLE_ID = R.ROLE_ID";
		return jdbcTemplate.query(sql, new UserMapper());	
	}
	public User findUser(int userId) {
		String sql="SELECT U.*, R.* FROM USERS U LEFT JOIN USERS_ROLES UR ON U.USER_ID = UR.USER_ID LEFT JOIN ROLES R ON UR.ROLE_ID = R.ROLE_ID WHERE U.USER_ID = ?";
		return jdbcTemplate.queryForObject(sql,new UserMapper(), userId);
	}
    public User findByUsername(String username) {
		String sql = "SELECT * FROM USERS U LEFT JOIN USERS_ROLES UR ON U.USER_ID = UR.USER_ID LEFT JOIN ROLES R ON UR.ROLE_ID = R.ROLE_ID WHERE USERNAME = ?";
		List<User> users = jdbcTemplate.query(sql, new UserMapper(), username);
		return users.isEmpty()?null:users.get(0);
	}

	public void createUser(User user) {

        String sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,EMAIL,BIRTH,STATUS) " +
                     "VALUES(?,?,?,?,?,?,?)";

		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getUserName());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getEmail());
				ps.setDate  (6, new java.sql.Date(user.getBirth().getTime()));
				ps.setString(7, user.getStatus());

				return ps;
			}
	    };

	    KeyHolder keyHolder = new GeneratedKeyHolder();

	    this.jdbcTemplate.update(psc, keyHolder);

	    int userId = keyHolder.getKey().intValue();

	    // USER_ROLE ROW CREATION

        String sqlUR = "INSERT INTO USERS_ROLES(USER_ID,ROLE_ID) VALUES(?,?)";

        jdbcTemplate.update(sqlUR,new Object[] {userId, user.getRole().getId() });

	}

    public void modifyUser(User user) {

        String sql = "UPDATE USERS SET USERNAME = ?, FIRST_NAME = ?, LAST_NAME = ?, EMAIL =?, BIRTH = ? " +
                     "WHERE USER_ID = ?";

        jdbcTemplate.update(sql,new Object[] {user.getUserName(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getBirth(), user.getId()});

		sql = "DELETE FROM USERS_ROLES WHERE USER_ID = ?";
        jdbcTemplate.update(sql,new Object[] {user.getId()});

        sql = "INSERT INTO USERS_ROLES(USER_ID,ROLE_ID) VALUES(?,?)";
        jdbcTemplate.update(sql,new Object[] {user.getId(), user.getRole().getId() });
    }

    public void deleteUser(int userId) {

		String sql = "DELETE FROM USERS_ROLES WHERE USER_ID = ?";
        jdbcTemplate.update(sql,new Object[] {userId});

		sql = "DELETE FROM USERS WHERE USER_ID = ?";
        jdbcTemplate.update(sql,new Object[] {userId});
    }
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

