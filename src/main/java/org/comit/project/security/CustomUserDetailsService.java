package org.comit.project.security;

import org.comit.project.bean.User;
import org.comit.project.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		User user = userDao.findByUsername(username);

		if (user==null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}

		return new CustomUserDetails(user);
	}

}
