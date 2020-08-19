package com.cg.sprint.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {
	@Id
	@Column(length = 4)
	private int movieId;
	@Column(length = 15)
	private String theatres;
	@Column(length = 30)
	private String movie;
	
	public Movies() {
		super();
	}
	
	public Movies(int movieId, String theatres, String movie) {
		super();
		this.movieId = movieId;
		this.theatres = theatres;
		this.movie = movie;
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTheatres() {
		return theatres;
	}
	public void setTheatres(String theatres) {
		this.theatres = theatres;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
}