package org.example.BookMyShow;

public class Seat {
    int id;
    int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public void setCategory(SeatCategory category) {
        this.category = category;
    }

    String row;
    SeatCategory category;
}
