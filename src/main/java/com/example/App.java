package com.example;
import java.util.Scanner;

public class App {
    static int currentPlayer = 1;
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        runGame();
    }

    public static void switchPayer() {
        System.out.printf( "player is switching");
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public static void runGame() {
        TicTacToe ticTacToe = new TicTacToe(1);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                ticTacToe.displayBoard();

                System.out.printf( "Enter your move, row and column for player %d ", currentPlayer);
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (!ticTacToe.placeMove(row, col, currentPlayer)) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                if (ticTacToe.gameEnded(row, col)) {
                    System.out.printf( "Playe %d wins!\n", currentPlayer);
                    break;
                }

                if (ticTacToe.isBoardFull()) {
                    System.out.println( "Enter your move, row and column" );
                    break;
                }
                switchPayer();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println( e );
        }
    }
}
