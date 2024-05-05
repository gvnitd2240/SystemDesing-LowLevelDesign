package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityWiseMovie;
    List<Movie> allMovies;

    MovieController() {
        cityWiseMovie = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public List<Movie> getMovies(City city) {
        return cityWiseMovie.get(city);
    }

    void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityWiseMovie.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityWiseMovie.put(city, movies);
    }

    Movie getMovieByName(String movieName) {

        for (Movie movie : allMovies) {
            if ((movie.getName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

}
