package com.poscodx.mysite.vo;

public class GalleryVo {
	private Long no;
	private String comment;
	private String imageUrl;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", comment=" + comment + ", imageUrl=" + imageUrl + "]";
	}
}
