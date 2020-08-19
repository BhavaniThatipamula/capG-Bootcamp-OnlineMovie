package com.cg.sprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//user
@Entity
@Table(name = "seats")
public class Seats {
	@Id
	@Column(length = 1)
	private int sno;
	@Column(length = 10)
	private String seatType;
	@Column(length = 3)
	private int availableSeats;
	@Column(length = 4)
	private int price;
	
	public Seats() {
		super();
	}
	
	public Seats(int sno, String seatType, int availableSeats, int price) {
		super();
		this.sno = sno;
		this.seatType = seatType;
		this.availableSeats = availableSeats;
		this.price = price;
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}