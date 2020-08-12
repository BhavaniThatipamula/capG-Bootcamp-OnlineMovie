package com.cg.onlinemovie.entity;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="movie_tbl")
public class Movie {
	
	public Movie() {
		super();
	}
	
public Movie(int movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}

	@Id
	@Column(name="movieId",length=4)
	private int movieId;
	
	@Column(name="movieName",length=15)
	private String movieName;
	
	@Column(name="movieGenre",length=15)
	private String movieGenre;
	
	@Column(name="movieDirector",length=15)
	private String movieDirector;
	
	@Column(name="movieLength")
	private int movieLength;
	
	@Column(name="movieReleaseDate")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="YYYY:MM:DD")
	private Date movieReleaseDate;
	
	

	public int getMovieId() {
		return movieId;
	}

	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	
	
	
	

}
