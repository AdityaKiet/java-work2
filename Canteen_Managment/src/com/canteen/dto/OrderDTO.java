package com.canteen.dto;

public class OrderDTO {
	private int id;
	private String name;
	private String items;
	private int token;
	private int amount;
	private String time;
	private boolean isConfirmed;
	private int expected_time;

	public boolean getisConfirmed() {
		return isConfirmed;
	}

	public void setisConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

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

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", name=" + name + ", items=" + items
				+ ", token=" + token + ", amount=" + amount + ", time=" + time
				+ ", isConfirmed=" + isConfirmed + ", expected_time="
				+ expected_time + "]";
	}

	public int getExpected_time() {
		return expected_time;
	}

	public void setExpected_time(int expected_time) {
		this.expected_time = expected_time;
	}

}
