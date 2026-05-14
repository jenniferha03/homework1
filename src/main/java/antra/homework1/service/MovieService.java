package antra.homework1.service;

import antra.homework1.movie.MovieData;
import antra.homework1.movie.MovieResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<MovieData> getAllMovies();

    MovieResponse searchMovies(String title, Integer year, Integer page);
}
