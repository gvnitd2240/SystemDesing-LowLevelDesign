package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    TheatreController() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {

        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        List<Theatre> allFilteredTheatre = cityVsTheatre.get(city);

        Map<Theatre, List<Show>> map = new HashMap<>();

        for (Theatre theatre: allFilteredTheatre){
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for (Show show: shows){
                if(show.movie.getId() == movie.getId()){
                    givenMovieShows.add(show);
                }
            }

            if(!givenMovieShows.isEmpty()){
                map.put(theatre, givenMovieShows);
            }

        }

        return map;
    }


}
