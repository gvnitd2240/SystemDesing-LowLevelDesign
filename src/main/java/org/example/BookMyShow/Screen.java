package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Screen {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeat() {
        return Seat;
    }

    public void setSeat(List<Seat> Seat) {
        this.Seat = Seat;
    }

    List<Seat> Seat = new ArrayList<Seat>();
}
