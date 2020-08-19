package com.cg.sprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	@Id
	@Column(length = 2)
	private int sno;
	@Column(length = 2)
	private int cityId;
	@Column(length = 10)
	private String cityNames;
	
	public City() {
		super();
	}
	
	public City(int sno, int cityId, String cityNames) {
		super();
		this.sno = sno;
		this.cityId = cityId;
		this.cityNames = cityNames;
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityNames() {
		return cityNames;
	}
	public void setCityNames(String cityNames) {
		this.cityNames = cityNames;
	}
	
}
