package com.canteen.dto;

import java.util.Date;

public class ReportsDTO {

	private Date date;
	private int amount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
		return "ReportDTO [date=" + date + ", amount=" + amount + "]";
	}

}
