package com.cg.sprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Languages {	
	@Id
	@Column(length = 1)
	private int sno;
	@Column(length = 10)
	private String language;
	
	public Languages() {
		super();
	}
	
	public Languages(int sno, String language) {
		super();
		this.sno = sno;
		this.language = language;
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}