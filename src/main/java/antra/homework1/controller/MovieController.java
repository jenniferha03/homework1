package antra.homework1.controller;

import antra.homework1.movie.MovieData;
import antra.homework1.movie.MovieResponse;
import antra.homework1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieData> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(params = "Title")
    public MovieResponse searchMovies(
            @RequestParam(value = "Title") String title,
            @RequestParam(value = "Year", required = false) Integer year,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
    ) {
        return movieService.searchMovies(title, year, page);
    }
}
