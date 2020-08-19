package com.cg.sprint.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
	@Id
	@Column(length = 5	)
	@GeneratedValue
	private int bookingId;
	@Column(length = 4)
	private int accountNo;
	@Column(length = 5)
	private int moneyCollected;
	@Column(length = 3)
	private int seatsBooked;
	@Column(length = 10)
	private String seatType;
	@Column(length = 5)
	private int refund;
	@Column(length = 10)
	private String dateOfTransac;

	public Payments() {
		super();
	}
	
	public Payments(int bookingId, int accountNo, int moneyCollected, int seatsBooked, String seatType, int refund,
			String dateOfTransac) {
		super();
		this.bookingId = bookingId;
		this.accountNo = accountNo;
		this.moneyCollected = moneyCollected;
		this.seatsBooked = seatsBooked;
		this.seatType = seatType;
		this.refund = refund;
		this.dateOfTransac = dateOfTransac;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMoneyCollected() {
		return moneyCollected;
	}
	public void setMoneyCollected(int moneyCollected) {
		this.moneyCollected = moneyCollected;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public int getRefund() {
		return refund;
	}
	public void setRefund(int refund) {
		this.refund = refund;
	}
	public String getDateOfTransac() {
		return dateOfTransac;
	}
	public void setDateOfTransac(String dateOfTransac) {
		this.dateOfTransac = dateOfTransac;
	}
}