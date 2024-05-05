package org.example.TicTacToe;

import java.util.*;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();
        Player p1 = new Player(1, "vivek", new PieceX());
        Player p2 = new Player(2, "keshav", new PieceO());

        players.add(p1);
        players.add(p2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner) {
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<HashMap<Integer, Integer>> freeSpaces =  gameBoard.getFreeCells();

            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }
            System.out.print("Player:" + playerTurn.userName + " Enter row,column: ");

            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.piece);
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.piece.type);
            if(winner) {
                return playerTurn.userName;
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].type != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].type != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
