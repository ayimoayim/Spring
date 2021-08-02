package com.my.blog.post.vo;

import java.sql.Timestamp;

public class PostVO {
	private String reg_no;
	private Timestamp reg_dt;
	private String user_no;
	private String name;
	private String title;
	private String content;
	private String categoryId;
	private String views_cnt;
	private String recommend_cnt;
	private String public_fl;
	private Timestamp edit_dt;
	private String del_fl;

	
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public Timestamp getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPublic_fl() {
		return public_fl;
	}
	public void setPublic_fl(String public_fl) {
		this.public_fl = public_fl;
	}
	public Timestamp getEdit_dt() {
		return edit_dt;
	}
	public void setEdit_dt(Timestamp edit_dt) {
		this.edit_dt = edit_dt;
	}
	public String getDel_fl() {
		return del_fl;
	}
	public void setDel_fl(String del_fl) {
		this.del_fl = del_fl;
	}
}
