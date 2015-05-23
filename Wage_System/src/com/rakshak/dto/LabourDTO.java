package com.rakshak.dto;

import java.util.List;

public class LabourDTO {
	private Integer id;
	private String name;
	private String number;
	private String area;
	private String avail_start_date;
	private String avail_end_date;
	private List<String> skills;

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAvail_start_date() {
		return avail_start_date;
	}

	public void setAvail_start_date(String avail_start_date) {
		this.avail_start_date = avail_start_date;
	}

	public String getAvail_end_date() {
		return avail_end_date;
	}

	public void setAvail_end_date(String avail_end_date) {
		this.avail_end_date = avail_end_date;
	}

	@Override
	public String toString() {
		return "LabourDTO [id=" + id + ", name=" + name + ", number=" + number
				+ ", area=" + area + ", avail_start_date=" + avail_start_date
				+ ", avail_end_date=" + avail_end_date + ", skills=" + skills
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (((LabourDTO) obj).getId().equals(this.id)) {
			result = true;
		}
		return result;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
