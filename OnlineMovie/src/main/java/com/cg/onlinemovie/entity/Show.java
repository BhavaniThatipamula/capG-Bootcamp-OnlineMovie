package com.cg.onlinemovie.entity;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/*************************************************************************************************************************
 *         @author          BhavaniThatipamula
 *         Description      It is an entity class of Show , which maps to a database table show_tbl , consists
 *          				of its private data members, setters and getters , parameterized and default constructors..
 *         Version          1.0
 *         Created Date     12-AUG-2020
 *************************************************************************************************************************/
 
@Entity
@Table(name="show_tbl")
public class Show {
	
	public Show() {
		super();
	}
public Show(int showId, String showName) {
		super();
		this.showId = showId;
		this.showName = showName;
	}

	@ManyToOne
	@JoinColumn(name="movieId")
	private Movie movie;	 

	@Id
	@Column(name="showId",length=8)
	private int showId;
	
	@Column(name="screenId",length=4)
	private int screenId;
	
	@Column(name="theatreId",length=4)
	private int theatreId;
	
	@Column(name="showName")
	private String showName;
	
	@Column(name="showStartTime",columnDefinition="TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="hh:mm:ss")
	private Date showStartTime;
	
	@Column(name="showEndTime",columnDefinition="TIMESTAMP")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="hh:mm:ss")
	private Date showEndTime;


	public int getShowId() {
		return showId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Date getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(Date showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Date getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(Date showEndTime) {
		this.showEndTime = showEndTime;
	}

	
	

}
