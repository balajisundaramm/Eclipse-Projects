package com.register;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private String email, pswd;

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
		System.out.println("In setEmail of login bean");
	}

	
	public String getPswd() {
		return pswd;
	}

	
	public void setPswd(String pswd) {
		this.pswd = pswd;
		System.out.println("in setPassword og loginBean");
	}

	public LoginBean() {
		super();
		System.out.println("In no arg const of login bean");
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pswd == null) ? 0 : pswd.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LoginBean)) {
			return false;
		}
		LoginBean other = (LoginBean) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (pswd == null) {
			if (other.pswd != null) {
				return false;
			}
		} else if (!pswd.equals(other.pswd)) {
			return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", pswd=" + pswd + "]";
	}
	
	
	public String validate() {
		StringBuilder sb=new StringBuilder();
		if(email==null || email.trim().equals(""))
			sb.append("Your email is mandatory<br/>");
		if(pswd==null || pswd.trim().equals(""))
			sb.append("Your password is mandatory<br/>");
				
		String msg=sb.toString();
		if(msg.equals(""))
			return "SUCCESS";
		else
			return msg;
	}

	
}
