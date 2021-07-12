package com.my.blog.user.vo;

import java.sql.Timestamp;

public class UserVO {
	private String reg_no;
	private Timestamp date;
	private String email;
	private String passowrd;
	private String name;
	private Timestamp edit_dt;
	private String del_fl;
	
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
