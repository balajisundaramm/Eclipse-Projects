package com.register;

import java.io.Serializable;

public class RegBean implements Serializable{
	private String name, email, pswd, rePswd;
	
	/* 1. normal java POJO
	 * 2. create no arg constructor
	 * 3. Must belong to a package
	 * 4. create as many instance variable as many inputs with SAME NAME
	 * 5. setter/ getter
	 * 6. equals, hash code, to string, implements serializable 
	 */
	
	public RegBean() {
		super();
		System.out.println("In no arg cons of regBean");
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
		System.out.println("In setName of regBean");

	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
		System.out.println("In setEmail of regBean");

	}

	
	public String getPswd() {
		return pswd;
	}

	
	public void setPswd(String pswd) {
		this.pswd = pswd;
		System.out.println("In setPswd of regBean");

	}

	
	public String getRePswd() {
		return rePswd;
	}

	
	public void setRePswd(String rePswd) {
		this.rePswd = rePswd;
		System.out.println("In setRePswd of regBean");

	}

	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pswd == null) ? 0 : pswd.hashCode());
		result = prime * result + ((rePswd == null) ? 0 : rePswd.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RegBean)) {
			return false;
		}
		RegBean other = (RegBean) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pswd == null) {
			if (other.pswd != null) {
				return false;
			}
		} else if (!pswd.equals(other.pswd)) {
			return false;
		}
		if (rePswd == null) {
			if (other.rePswd != null) {
				return false;
			}
		} else if (!rePswd.equals(other.rePswd)) {
			return false;
		}
		return true;
	}

	
	public String toString() {
		return "RegBean [name=" + name + ", email=" + email + ", pswd=" + pswd + ", rePswd=" + rePswd + "]";
	}
	
	public String validate() {
		StringBuilder sb=new StringBuilder();
		if(name==null || name.trim().equals(""))
			sb.append("Your name is mandatory<br/>");
		if(email==null || email.trim().equals(""))
			sb.append("Your email is mandatory<br/>");
		if(pswd==null || pswd.trim().equals(""))
			sb.append("Your password is mandatory<br/>");
		else
			if(!rePswd.equals(pswd))
				sb.append("enter the same password!!<br/>");
				
		String msg=sb.toString();
		if(msg.equals(""))
			return "SUCCESS";
		else
			return msg;
	}

	

}
