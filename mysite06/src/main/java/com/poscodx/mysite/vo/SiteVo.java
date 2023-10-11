package com.poscodx.mysite.vo;

public class SiteVo {
	private Long no;
	private String title;
	private String welcome;
	private String profile;
	private String description;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SiteVo [no=" + no + ", title=" + title + ", welcome=" + welcome + ", profile=" + profile
				+ ", description=" + description + "]";
	}
}
