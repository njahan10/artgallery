package org.comit.project.bean;

public class Art extends Entity {
	public String title;
	public String size;
	public String description;
	public String imageName;
	public String imageUUID;
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
	
	public String getImageName() {		
		return this.imageName;		
	}
	
	public void setImageName(String imageName) {		
		this.imageName = imageName;		
	}
	
	public String getImageUUID() {		
		return this.imageUUID;		
	}
	
	public void setImageUUID(String imageUUID) {		
		this.imageUUID = imageUUID;		
	}

	@Override
	public String toString() {
		return "Art [title=" + title + ", size=" + size + ", description=" + description + ", imageName=" + imageName
				+ ", imageUUID=" + imageUUID + ", price=" + price + "]";
	}
	
}
