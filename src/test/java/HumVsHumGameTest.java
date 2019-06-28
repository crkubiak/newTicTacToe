import org.junit.Test;

import static org.junit.Assert.*;

public class HumVsHumGameTest {
    @Test
    public void testGameStartsWithPlayerX() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        Game game = new HumVsHumGame(board, validation, rules);
        String expectedMarker = "X";
        String actualMarker = game.currentPlayer();
        assertEquals(expectedMarker,actualMarker);
    }

    @Test
    public void testGameSwitchesToNextPlayer() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        Game game = new HumVsHumGame(board, validation, rules);
        game.move(1);
        String expectedMarker = "O";
        String actualMarker = game.currentPlayer();
        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    public void testBoardMarkedWhenTurnTaken() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        Game game = new HumVsHumGame(board, validation, rules);
        game.move(1);
        String[] expectedBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testMultipleTurnsMarkedOnBoard() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        Game game = new HumVsHumGame(board, validation, rules);
        game.move(4);
        game.move(6);
        String[] expectedBoard = {"1", "2", "3", "X", "5", "O", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }
}