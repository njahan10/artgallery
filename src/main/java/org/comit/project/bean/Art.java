package org.comit.project.bean;

public class Art extends Entity {
	public String title;
	public String size;
	public String description;
	public String imagePath;
	public double price;	
	
	public String getTitle() {		
		return this.title;		
	}
	
	public void setTitle(String title) {		
		this.title = title;		
	}
	
	public String getSize() {		
		return this.size;		
	}	
	public void setSize(String size) {		
		this.size = size;		
	}
	
	public String getDescription() {		
		return this.description;		
	}
	
	public void setDescription(String description) {		
		this.description = description;		
	}	
	public double getPrice() {		
		return this.price;		
	}
	
	public void setPrice(double price) {		
		this.price = price;		
	}
	
	public String getImagePath() {		
		return this.imagePath;		
	}
	
	public void setImagePath(String imagePath) {		
		this.imagePath = imagePath;		
	}	
}
