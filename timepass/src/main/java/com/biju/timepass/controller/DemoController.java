package com.biju.timepass.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biju.timepass.entity.Movies;
import com.biju.timepass.entity.UserProfile;
import com.biju.timepass.service.MovieService;
import com.biju.timepass.serviceImpl.ExcelGenerator;

@Controller
public class DemoController {

	@Autowired
	MovieService movieService;

	@GetMapping("/")
	public String hello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		System.out.println("It's a hit");
		return "hello";
	}

	@GetMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "accessDenied";

	}

	@GetMapping("/userlistpage")
	public String listUsers(Model theModel) {
		List<UserProfile> users = movieService.findAllUsers();
		theModel.addAttribute("users", users);
		return "userlistpage";
	}

	@GetMapping("/movielistpage")
	public String listMovies(Model theModel) {
		List<Movies> movies = movieService.findAllMovies();
		theModel.addAttribute("movies", movies);
		return "movielistpage";
	}
	
	@GetMapping("/downloadMovies")
	public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<Movies> movies = movieService.findAllMovies();
    
    ByteArrayInputStream in = ExcelGenerator.moviesToExcel(movies);
    // return IOUtils.toByteArray(in);
    
    HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=movies.xlsx");
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
    }

	@GetMapping("/addNewMovie")
	public String showNewMovieForm(Model theModel) {
		Movies movies = new Movies();
		theModel.addAttribute("movies", movies);
		return "addMovie";
	}

	@PostMapping("/save/movie")
	public String saveNewMovies(@ModelAttribute("movies") Movies movie) {
		movieService.saveMovie(movie);
		return "redirect:/movielistpage";
	}

	@GetMapping("/movies/showFormForUpdate")
	public String updateMovie(@RequestParam("movieId") int theId, Model theModel) {
		Movies movies = movieService.findMovieById(theId);
		theModel.addAttribute(movies);
		return "addMovie";
	}
	
	@GetMapping("/user/showFormForUpdate")
	public String updateUser(@RequestParam("userId") int theId, Model theModel) {
		UserProfile user = movieService.findUserById(theId);
		theModel.addAttribute(user);
		return "addUser";
	}

	@GetMapping("/movies/delete")
	public String deleteMovie(@RequestParam("movieId") int theId) {
		movieService.deleteMovieById(theId);
		return "redirect:/movielistpage";
	}
	
	@GetMapping("/user/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		movieService.deleteUserById(theId);
		return "redirect:/userlistpage";
	}
}
