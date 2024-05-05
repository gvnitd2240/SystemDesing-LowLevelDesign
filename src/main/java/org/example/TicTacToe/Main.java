package org.example.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeGame();
        String winner = game.startGame();

        System.out.println("the winner is "+winner);
    }
}
