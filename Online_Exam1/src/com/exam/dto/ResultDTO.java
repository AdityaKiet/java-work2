package com.exam.dto;

public class ResultDTO {
	private String userid;
	private String quiz_id;
	private String quiz_name;
	private int score;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getQuiz_id() {
		return quiz_id;
	}
	public String getQuiz_name() {
		return quiz_name;
	}
	public void setQuiz_name(String quiz_nmae) {
		this.quiz_name = quiz_nmae;
	}
	public void setQuiz_id(String quiz_id) {
		this.quiz_id = quiz_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ResultDTO [userid=" + userid + ", quiz_id=" + quiz_id
				+ ", quiz_name=" + quiz_name + ", score=" + score + "]";
	}
	
	
}
