package com.cg.onlinemovie.entity;
 

import javax.persistence.Column;
import javax.persistence.Entity;
 
 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
 
import javax.persistence.Table;


@Entity
@Table(name="screen_tbl")
public class Screen {
	
	public Screen() {
		super();
	}
	
public Screen(int screenId, String screenName, int nrows, int ncolumns) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.nrows = nrows;
		this.ncolumns = ncolumns;
	}

	@ManyToOne 
	@JoinColumn(name="theatreId")
	private Theatre theatre;
	
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	@Id
	@Column(name="screenId",length=4)
	private int screenId;
	
	@Column(name="screenName",length=15)
	private String screenName;
	
	@Column(name="nrows")
	private int nrows;
	
	@Column(name="ncolumns")
	private int ncolumns;
	
	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
 
	public String getScreenName() {
		return screenName;
	}



	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}



	public int getNrows() {
		return nrows;
	}



	public void setNrows(int nrows) {
		this.nrows = nrows;
	}



	public int getNcolumns() {
		return ncolumns;
	}



	public void setNcolumns(int ncolumns) {
		this.ncolumns = ncolumns;
	}
 
	
	
	

}
