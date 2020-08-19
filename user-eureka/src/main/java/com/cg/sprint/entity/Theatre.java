package com.cg.sprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//user
@Entity
@Table(name = "theatre")
public class Theatre {
	@Id
	@Column(length = 3)
	private int theatreId;
	@Column(length = 10)
	private String cityName;
	@Column(name = "theatreName", length = 10)
	private String theatreName;
	
	public Theatre() {
		super();
	}
	
	public Theatre(int theatreId, String cityName, String theatreName) {
		super();
		this.theatreId = theatreId;
		this.cityName = cityName;
		this.theatreName = theatreName;
	}

	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}	
}
