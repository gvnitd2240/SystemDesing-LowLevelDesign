package org.example.TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if(board[row][column] != null){
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public List<HashMap<Integer, Integer>> getFreeCells() {
        List<HashMap<Integer, Integer>> freeCells = new ArrayList<>();
        for (int i =0; i<size;i++){
            for (int j =0;j<size;j++){
                if(board[i][j] == null){
                    HashMap<Integer, Integer> rowColumn = new HashMap<>();
                    rowColumn.put(i,j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }
    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].type.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}

