package com.biju.timepass.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movies implements Serializable {
	
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieID;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "mv_description")
	private String mvDescription;

	public Movies() {
		super();
		System.out.println("defualt constructor movie table");
	}

	public Movies(Integer movieID, String movieName, String releaseDate, String mvDescription) {
		super();
		System.out.println("parameterised constructor movie table");
		this.movieID = movieID;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.mvDescription = mvDescription;
	}

	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMvDescription() {
		return mvDescription;
	}

	public void setMvDescription(String mvDescription) {
		this.mvDescription = mvDescription;
	}

	@Override
	public String toString() {
		return "Movies [movieID=" + movieID + ", movieName=" + movieName + ", releaseDate=" + releaseDate
				+ ", mvDescription=" + mvDescription + "]";
	}
	
}
