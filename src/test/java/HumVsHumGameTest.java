import org.junit.Test;

import static org.junit.Assert.*;

public class HumVsHumGameTest {

    @Test
    public void gameStartsWithPlayerX() {

        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        HumVsHumGame humVsHumGame = new HumVsHumGame(board, validation, rules);
        assertEquals("X", humVsHumGame.currentPlayer());
    }

    @Test
    public void gameSwitchesToNextPlayer() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        HumVsHumGame humVsHumGame = new HumVsHumGame(board, validation, rules);
        humVsHumGame.move(1);
        assertEquals("O", humVsHumGame.currentPlayer());
    }

    @Test
    public void boardMarkedWhenTurnTaken() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        HumVsHumGame humVsHumGame = new HumVsHumGame(board, validation, rules);
        humVsHumGame.move(1);
        String[] expectedBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

    @Test
    public void multipleTurnsMarkedOnBoard() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        HumVsHumGame humVsHumGame = new HumVsHumGame(board, validation, rules);

        humVsHumGame.move(4);
        humVsHumGame.move(6);
        String[] expectedBoard = {"1", "2", "3", "X", "5", "O", "7", "8", "9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }
}