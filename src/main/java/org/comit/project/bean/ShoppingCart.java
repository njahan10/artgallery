package org.comit.project.bean;

import java.util.Date;

public class ShoppingCart extends Entity {
	public Art art;
	public int quantity;
	public User user;
	public Date dateAdded;
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Art getArt() {
		return art;
	}
	public void setArt(Art art) {
		this.art = art;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ShoppingCart [art_id=" + art.id + ", quantity=" + quantity + ", user_id=" + user.id + ", cart_id=" + id + ", getId()="
				+ getId() + "]";
	}
	
	
	

}
