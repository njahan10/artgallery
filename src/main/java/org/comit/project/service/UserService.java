package org.comit.project.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.comit.project.bean.User;
import org.comit.project.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;




@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> listUsers(){

		List<User> users = userDao.listUsers();

		users.forEach(System.out::println);

//		users.removeIf(user-> !"A".equals(user.getStatus()));

		return users;
	}

	public User findUser(int idUser) {

		return userDao.findUser(idUser);
	}

	public void createUser(User user) {

		this.validateUser(user);
		user.setStatus("A");
        userDao.createUser(user);
	}

    public void modifyUser(User user) {

    	this.validateUser(user);
    	userDao.modifyUser(user);
    }

    public void deleteUser(int idUser) {

    	userDao.deleteUser(idUser);
    }

    private void validateUser(User user) {

    	if (user.getFirstName().isEmpty() ||
    		user.getLastName().isEmpty() ||
    		user.getUserName().isEmpty()) {
    		throw new RuntimeException("Invalid User Data " + user);
    	}
    }
}

