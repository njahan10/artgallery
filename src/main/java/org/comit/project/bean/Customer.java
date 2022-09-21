package org.comit.project.bean;

import java.util.List;

public class Customer extends Entity {	
	
	public String first_name;
	public String last_name;
	public String email;
	public String password;
	public String address;
	
	List<Order>orders;
	
	
	
	public String getFirstname() {
		return first_name;
	}
	public void setFirstname(String first_name) {
		this.first_name = first_name;
	}
	public String getLastname() {
		return last_name;
	}
	public void setLastname(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password="
				+ password + ", address=" + address +  "]";
	}
	
}
	
	
	


