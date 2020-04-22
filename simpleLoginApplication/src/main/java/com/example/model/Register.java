package com.example.model;

public class Register {
	private String userid;
	private String email;
	private String password;
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Register [userid=" + userid + ", email=" + email + ", password=" + password + "]";
	}
	
}
