package com.oy.pojo;

public class UesrInfo {
	public String id;
	public String name;
	public String age;
	public String sex;
	public String phone;
	public String email;
	public UesrInfo(){}
	public UesrInfo(String id, String name, String age, String sex, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UesrInfo [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
}
