package org.comit.project.bean;

import java.util.List;

public class UserRoles {
	public User user;
	public List<Role> roles;
	
	public UserRoles(User user, List<Role> roles) {
		this.user = user;
		this.roles = roles;
	}
}
