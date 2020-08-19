package com.cg.sprint.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//user
@Entity
@Table(name = "refund")
public class Refund {
	@Id
	@Column(length = 5)
	@GeneratedValue
	private int sno;
	@Column(length = 4)
	private int accountNo;
	@Column(length = 5)
	private int moneyRefunded;
	@Column(length = 10)
	private int bookingId;
	@Column(length = 10)
	private String dateOfRefund;

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMoneyRefunded() {
		return moneyRefunded;
	}
	public void setMoneyRefunded(int moneyRefunded) {
		this.moneyRefunded = moneyRefunded;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getDateOfRefund() {
		return dateOfRefund;
	}
	public void setDateOfRefund(String dateOfRefund) {
		this.dateOfRefund = dateOfRefund;
	}
}