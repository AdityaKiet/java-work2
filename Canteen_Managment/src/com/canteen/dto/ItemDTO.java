package com.canteen.dto;

public class ItemDTO {
	private int id;
	private String name;
	private String price;
	private boolean isAvailable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean getisAvailable() {
		return isAvailable;
	}

	public void setisAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "ItemDTO [id=" + id + ", name=" + name + ", price=" + price
				+ ", isAvailable=" + isAvailable + "]";
	}

}
