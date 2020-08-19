package com.cg.sprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
@Table(name = "account")
public class Account {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length = 2)
	private int sno;
	@Id
	@Column(length = 30)
	private String username;
	@Column(length = 15)
	private String password;
	@Column(length = 15)
	private String name;
	@Email(message="Enter Proper Email Id")
    String email;
	@Min(value=10)
	private long userPhoneno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUserPhoneno() {
		return userPhoneno;
	}
	public void setUserPhoneno(long userPhoneno) {
		this.userPhoneno = userPhoneno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//user
}
