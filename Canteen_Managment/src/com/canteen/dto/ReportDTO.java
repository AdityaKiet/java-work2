package com.canteen.dto;

import java.util.Date;

public class ReportDTO {

	private String customer;
	private String item;
	private Date date;
	private Double amount;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ReportDTO [customer=" + customer + ", item=" + item + ", date="
				+ date + ", amount=" + amount + "]";
	}

}
