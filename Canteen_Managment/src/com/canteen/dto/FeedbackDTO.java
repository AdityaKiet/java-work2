package com.canteen.dto;

public class FeedbackDTO {
	private int id;
	private String name;
	private String category;
	private String text;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return "FeedbackDTO [id=" + id + ", name=" + name + ", category="
				+ category + ", text=" + text + "]";
	}

}
