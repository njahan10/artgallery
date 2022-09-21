package org.comit.project.service;
import java.util.List;
import org.comit.project.bean.User;
import org.comit.project.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDao userDao;

	public List<User> listUsers(){

		List<User> users = userDao.listUsers();

		users.removeIf(user-> !"A".equals(user.getStatus()));
		return users;
	}

	public User findUser(int idUser) {

		return userDao.findUser(idUser);
	}
	

	public User findByUsername(String username) {

		return userDao.findByUsername(username);
	}
	

	@Transactional(propagation=Propagation.REQUIRED)
	public void createUser(User user) {

		this.validateUser(user);
		user.setStatus("A");
        userDao.createUser(user);
	}

	@Transactional(propagation=Propagation.REQUIRED)
    public void modifyUser(User user) {

    	this.validateUser(user);
    	userDao.modifyUser(user);
    }

	@Transactional(propagation=Propagation.REQUIRED)
    public void deleteUser(int idUser) {

    	userDao.deleteUser(idUser);
    }

    private void validateUser(User user) {

    	if (user.getFirstName().isEmpty() ||
    		user.getLastName().isEmpty() ||
    		user.getUserName().isEmpty()) {
    		logger.error("Invalid User Data " + user);
    		throw new RuntimeException("Invalid User Data " + user);
    	}
    }
}