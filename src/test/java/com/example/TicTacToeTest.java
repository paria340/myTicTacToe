package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe ticTacToe;
    
    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe(1);
    }

    @Test
    void testPlaceMove() {
        boolean placeMove = ticTacToe.placeMove(1, 1, 1);
        assertTrue(placeMove, "The move should be in bounds");
    }

    @Test
    void testPlaceMoveFailNegative() {
        boolean result = ticTacToe.placeMove(5, 1, 1);
        assertTrue(!result, "The move should be out of bounds");

        result = ticTacToe.placeMove(5, -1, 1);
        assertTrue(!result, "The move should be out of bounds");
    }

    @Test
    void testPlaceMoveFail() {
        boolean placeMove = ticTacToe.placeMove(5, 1, 1);
        assertTrue(!placeMove, "The move should be out of bounds");
    }

    @Test
    void testCheckRowWin() {
        int[][] board = 
            {{1, 1, 1}, 
            {0, 1, 2}, 
            {2, 1, 2}
        };
        ticTacToe.setBoard(board);
        boolean result = ticTacToe.checkRow(0);
        assertTrue(result, "Row one player one has won");
    }
}
