package com.my.blog.post.vo;

import java.sql.Timestamp;

public class CommentVO {
	private String reg_no;
	private Timestamp reg_dt;
	private String user_no;
	private String post_no;
	private String parent_no;
	private String depth;
	private String seq;
	private String name;
	private String password;
	private String content;
	private String ip;
	private Timestamp edit_dt;
	private String public_fl;
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
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getParent_no() {
		return parent_no;
	}
	public void setParent_no(String parent_no) {
		this.parent_no = parent_no;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getEdit_dt() {
		return edit_dt;
	}
	public void setEdit_dt(Timestamp edit_dt) {
		this.edit_dt = edit_dt;
	}
	public String getPublic_fl() {
		return public_fl;
	}
	public void setPublic_fl(String public_fl) {
		this.public_fl = public_fl;
	}
	public String getDel_fl() {
		return del_fl;
	}
	public void setDel_fl(String del_fl) {
		this.del_fl = del_fl;
	}
}
