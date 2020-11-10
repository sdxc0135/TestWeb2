package com.TestWeb.user.model;

import java.sql.Timestamp;

public class UserDTO {
	
	String id;
	String pw; 
	String name; 
	String phone_number1; 
	String phone_number2; 
	String phone_number3; 
	String email1;
	String email2;
	String address1;
	String address2;
	Timestamp regdate;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public UserDTO(String id, String pw, String name, String phone_number1, String phone_number2, String phone_number3,
			String email1, String email2, String address1, String address2, Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone_number1 = phone_number1;
		this.phone_number2 = phone_number2;
		this.phone_number3 = phone_number3;
		this.email1 = email1;
		this.email2 = email2;
		this.address1 = address1;
		this.address2 = address2;
		this.regdate = regdate;
	}

	

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone_number1=" + phone_number1
				+ ", phone_number2=" + phone_number2 + ", phone_number3=" + phone_number3 + ", email1=" + email1
				+ ", email2=" + email2 + ", address1=" + address1 + ", address2=" + address2 + ", regdate=" + regdate
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number1() {
		return phone_number1;
	}

	public void setPhone_number1(String phone_number1) {
		this.phone_number1 = phone_number1;
	}

	public String getPhone_number2() {
		return phone_number2;
	}

	public void setPhone_number2(String phone_number2) {
		this.phone_number2 = phone_number2;
	}

	public String getPhone_number3() {
		return phone_number3;
	}

	public void setPhone_number3(String phone_number3) {
		this.phone_number3 = phone_number3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	
	
	
}
