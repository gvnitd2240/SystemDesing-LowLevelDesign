package org.example.TicTacToe;

public class Player {
    int id;
    String userName;
    PlayingPiece piece;

    Player(int id, String userName, PlayingPiece piece){
        this.id = id;
        this.userName = userName;
        this.piece = piece;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PlayingPiece getPiece() {
        return piece;
    }

    public void setPiece(PlayingPiece piece) {
        this.piece = piece;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
