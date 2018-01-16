package com.beans;

public class RegBean {
	private String name;
	private String email,pwd,rPwd;
	
	public RegBean() {
		System.out.println("in regbean constructor");
	}
	
	public String getName() {
		System.out.println("In name getter");
		return name;
	}
	
	public void setName(String name) {
		System.out.println("In name setter");
		this.name = name;
	}
	
	public String getEmail() {
		System.out.println("In Email getter");
		return email;
	}
	
	public void setEmail(String email) {
		System.out.println("In email setter");
		this.email = email;
	}
	
	public String getPwd() {
		System.out.println("In pwd getter");
		return pwd;
	}
	
	public void setPwd(String pwd) {
		System.out.println("In pwd setter");
		this.pwd = pwd;
	}

	
	public String getrPwd() {
		System.out.println("in rPwd getter");
		return rPwd;
	}

	
	public void setrPwd(String rPwd) {
		System.out.println("in rPwd setter");
		this.rPwd = rPwd;
	}
	
		
}
