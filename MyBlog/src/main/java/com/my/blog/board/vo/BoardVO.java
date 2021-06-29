package com.my.blog.board.vo;

import java.sql.Timestamp;

public class BoardVO {
	private String regnum;
	private Timestamp regdate;
	private String userId;
	private String title;
	private String content;
	private String categoryId;
	private String views_cnt;
	private String recommend_cnt;
	private String type;
	
	public String getRegnum() {
		return regnum;
	}
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getViews_cnt() {
		return views_cnt;
	}
	public void setViews_cnt(String views_cnt) {
		this.views_cnt = views_cnt;
	}
	public String getRecommend_cnt() {
		return recommend_cnt;
	}
	public void setRecommend_cnt(String recommend_cnt) {
		this.recommend_cnt = recommend_cnt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
