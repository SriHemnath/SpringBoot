package com.biju.timepass.service;

import java.util.List;

import com.biju.timepass.entity.Movies;
import com.biju.timepass.entity.UserProfile;

public interface MovieService {

	public List<UserProfile> findAllUsers();
	
	public List<Movies> findAllMovies();
	
	public void saveMovie(Movies Movie);
	
	public Movies findMovieById(int id);
	
	public UserProfile findUserById(int id);
	
	public void deleteMovieById(int id);
	
	public void deleteUserById(int id);
	
}
