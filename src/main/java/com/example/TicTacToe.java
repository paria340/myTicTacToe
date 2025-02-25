package com.example;

public class TicTacToe {
    // With static modifier all instances of tic tac tow will share the same copy of variables
    private final int rows = 3;
    private final int columns = 3;
    private int currPlayer;
    private int[][] board; 

    // {{0 0 0}, 
    //  {0 0 0}, 
    //  {0 0 0 }}
    // - - -
    // - - -
    // - - -

    public TicTacToe(int currPlayer) {
        this.currPlayer = currPlayer;
        board = new int[rows][columns];
    };

    void setBoard(int[][] newBoard) {
        this.board = newBoard;
    }

    public boolean placeMove(int row, int col, int currentPlayer) {
        if (row < 0 || row >= rows || col < 0 || col >= columns || board[row][col] != 0) {
            return false;
        }
        this.currPlayer = currentPlayer;
        board[row][col] = currPlayer;
        return true;
    }

    public void displayBoard() {
        System.out.println("***************");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char symbol = (board[i][j] == 0) ? '-' : (board[i][j] == 1) ? 'X' : 'O';
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println("***************");
    }

    public boolean isBoardFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(int row) {
        for (int i = 0; i < columns; i++) {
            if (board[row][i] != currPlayer) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int col) {
        for (int i = 0; i < rows; i++) {
            if (board[i][col] != currPlayer) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiag() {
        for (int i = 0; i < rows; i++) {
            if (board[i][i] != currPlayer) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAntiDiag() {
        for (int i = 0; i < rows; i++) {
            if (board[i][rows - i - 1] != currPlayer) {
                return false;
            }
        }
        return true;
    }

    public boolean gameEnded(int row, int col) {
        return checkRow(row) || checkCol(col) || checkDiag() || checkAntiDiag();
    }
}

