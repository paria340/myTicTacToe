package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @BeforeEach
    void setUp() {
        App.currentPlayer = 1;
    }

    @Test
    void testSwitchPlayer() {
        App.currentPlayer = 1;
        App.switchPayer();
        assertEquals(2, App.currentPlayer);
    }
}
