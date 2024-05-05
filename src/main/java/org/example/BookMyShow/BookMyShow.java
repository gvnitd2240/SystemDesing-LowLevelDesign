package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    TheatreController theatreController;
    MovieController movieController;


    BookMyShow(){
        theatreController = new TheatreController();
        movieController = new MovieController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");

    }

    public void initialize() {
        createMovies();
        createTheatre();

    }

    public void createBooking(City city, String movieName){
        List<Movie> movieVsCity = movieController.getMovies(city);

        Movie interestedMovie = null;

        for (Movie movie: movieVsCity){
            if(movie.getName() == movieName){
                interestedMovie = movie;
            }
        }

        Map<Theatre, List<Show>> theaterVsMShow =  theatreController.getAllShow(interestedMovie, city);

        Map.Entry<Theatre,List<Show>> entry = theaterVsMShow.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);


        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeat()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeatsBooked(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setId(1);
        inoxTheatre.setScreens(createScreen());
        inoxTheatre.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreens().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreens().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setId(2);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreens().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreens().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.BANGALORE);
        theatreController.addTheatre(pvrTheatre, City.DELHI);

    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setId(1);
        screen1.setSeat(createSeats());
        screens.add(screen1);

        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime);
        return show;
    }

    //creating 100 seats
    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setId(i);
            seat.setCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setId(i);
            seat.setCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setId(i);
            seat.setCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie();
        avengers.setId(1);
        avengers.setName("AVENGERS");
        avengers.setDuration(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setId(2);
        baahubali.setName("BAAHUBALI");
        baahubali.setDuration(180);


        //add movies against the cities
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(baahubali, City.BANGALORE);
        movieController.addMovie(baahubali, City.DELHI);
    }

}
