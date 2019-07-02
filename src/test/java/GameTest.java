import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void gameStartsWithPlayerX() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, rules, validation, playerOne, playerTwo);
        String expectedPlayer = "X";
        String actualPlayer = game.currentPlayer().getMarker();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void gameSwitchesToNextPlayer() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, rules, validation, playerOne, playerTwo);
        game.move(1);
        String expectedPlayer = "O";
        String actualPlayer = game.currentPlayer().getMarker();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void boardMarkedWhenTurnTaken() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, rules, validation, playerOne, playerTwo);
        game.move(1);
        String[] expectedBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void multipleTurnsMarkedOnBoard() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, rules, validation, playerOne, playerTwo);
        game.move(2);
        game.move(3);
        String[] expectedBoard = {"1", "X", "O", "4", "5", "6", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }
}