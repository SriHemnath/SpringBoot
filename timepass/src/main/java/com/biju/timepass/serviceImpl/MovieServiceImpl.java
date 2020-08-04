package com.biju.timepass.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biju.timepass.dao.MovieRepository;
import com.biju.timepass.dao.UserRepository;
import com.biju.timepass.entity.Movies;
import com.biju.timepass.entity.UserProfile;
import com.biju.timepass.globalhandler.UserNotFoundException;
import com.biju.timepass.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<UserProfile> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<Movies> findAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void saveMovie(Movies movie) {
		movieRepository.save(movie);

	}

	@Override
	public Movies findMovieById(int id) {

		Optional<Movies> result = movieRepository.findById(id);
		Movies movie = null;
		if (result.isPresent()) {
			movie = result.get();
		} else {
			throw new UserNotFoundException("Movie not found - " + id);
		}
		return movie;
	}
	
	@Override
	public UserProfile findUserById(int id) {
		
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found = " +id));

	}

	@Override
	public void deleteMovieById(int id) {
		movieRepository.deleteById(id);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
		
	}

}
