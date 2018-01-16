package com.uttara.spring;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class InputBean {

	@NotBlank
	@Length(min=3,max=30)
	private String uname;
	
	@NotNull
	@Range(min=10,max=60)
	private int age;
	
	public InputBean() {
		System.out.println("in InputBean no-arg constr");
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("in IB->setUname() uname = "+uname);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("in IB->setAge() age = "+age);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputBean other = (InputBean) obj;
		if (age != other.age)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InputBean [uname=" + uname + ", age=" + age + "]";
	}
	
}
