package org.comit.project.bean;

import java.util.Date;

public class User extends Entity {	
	public String first_name;
	public String last_name;	
	public String username;
	public String email;
	public String password;
	public  Date  birth;
	public String status;	
	public Role role;
	
	public User() {

	}
	public User(int id, String first_name, String last_name, String username,String email, String password, Date birth,
			String status, Role role) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.status = status;

		this.role = role;
	}
	
	public String getFirstName() {
		return this.first_name;
	}	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return this.last_name;				
	}	
	public void setLastName(String last_name) {		
		this.last_name = last_name;
	}	
	public String getUserName() {
		return this.username;		
	}	
	public void setUserName(String username) {
		this.username = username;		
	}	
	public String getEmail() {
		return this.email;		
	}	
	public void setEmail(String email) {
		
		this.email = email;		
	}	
	public String getPassword() {
		return this.password;		
	}
	
	public void setPassword(String password) {		
		this.password = password;		
	}
	public Date getBirth() {
		return this. birth;		
	}
	public void setBirth(Date birth) {
		this.birth=birth;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this. status=status;
	}

	public String getFullName() {
		String fullname = this.first_name+" "+this.last_name;
		return fullname;		
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username + ", email="
				+ email + ", password=" + password + ", birth=" + birth + ", status=" + status + "]";
	}
}
