package com.biju.timepass.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews implements Serializable{

	@Id
	@Column(name = "review_id")
	private Integer reviewID;
	
	@JoinColumn(name = "movie_id")
	private Movies movieID;
	
	@Column(name = "rv_comments")
	private String rvComments;

	public Reviews() {
		super();
		System.out.println("default constructor reviews");
	}

	public Reviews(Integer reviewID, Movies movieID, String rvComments) {
		super();
		System.out.println("parameterised constructor review table");
		this.reviewID = reviewID;
		this.movieID = movieID;
		this.rvComments = rvComments;
	}

	public Integer getReviewID() {
		return reviewID;
	}

	public void setReviewID(Integer reviewID) {
		this.reviewID = reviewID;
	}

	public Movies getMovieID() {
		return movieID;
	}

	public void setMovieID(Movies movieID) {
		this.movieID = movieID;
	}

	public String getRvComments() {
		return rvComments;
	}

	public void setRvComments(String rvComments) {
		this.rvComments = rvComments;
	}

	@Override
	public String toString() {
		return "Reviews [reviewID=" + reviewID + ", movieID=" + movieID + ", rvComments=" + rvComments + "]";
	}
	
}
