package com.coreSpring;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class RegBean implements Serializable {
	@NotEmpty(message="enter this")
	private String uname;
	@NotEmpty
	@Email
	private String uemail;
	@NotEmpty
	@Length(min=5, max=10)
	private String upass;
	@NotEmpty
	@Length(min=5, max=10)
	private String rpass;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past
	private Date udate;
	
	public RegBean() {
		super();
		System.out.println("RegBean--> no arg cons");
	}

	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("RegBean--> setUname");

	}
	
	public String getUemail() {
		return uemail;
	}
	
	public void setUemail(String uemail) {
		this.uemail = uemail;
		System.out.println("RegBean--> setemail");

	}
	
	public String getUpass() {
		return upass;
	}
	
	public void setUpass(String upass) {
		this.upass = upass;
		System.out.println("RegBean--> setpass");

	}
	
	public String getRpass() {
		return rpass;
	}
	
	public void setRpass(String rpass) {
		this.rpass = rpass;
		System.out.println("RegBean--> setrpass");

	}
	
	public Date getUdate() {
		return udate;
	}
	
	public void setUdate(Date udate) {
		this.udate = udate;
		System.out.println("RegBean--> setdob");

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rpass == null) ? 0 : rpass.hashCode());
		result = prime * result + ((udate == null) ? 0 : udate.hashCode());
		result = prime * result + ((uemail == null) ? 0 : uemail.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((upass == null) ? 0 : upass.hashCode());
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
		if (!(obj instanceof RegBean)) {
			return false;
		}
		RegBean other = (RegBean) obj;
		if (rpass == null) {
			if (other.rpass != null) {
				return false;
			}
		} else if (!rpass.equals(other.rpass)) {
			return false;
		}
		if (udate == null) {
			if (other.udate != null) {
				return false;
			}
		} else if (!udate.equals(other.udate)) {
			return false;
		}
		if (uemail == null) {
			if (other.uemail != null) {
				return false;
			}
		} else if (!uemail.equals(other.uemail)) {
			return false;
		}
		if (uname == null) {
			if (other.uname != null) {
				return false;
			}
		} else if (!uname.equals(other.uname)) {
			return false;
		}
		if (upass == null) {
			if (other.upass != null) {
				return false;
			}
		} else if (!upass.equals(other.upass)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "RegBean [uname=" + uname + ", uemail=" + uemail + ", upass=" + upass + ", rpass=" + rpass + ", udate="
				+ udate + "]";
	}
	
}
