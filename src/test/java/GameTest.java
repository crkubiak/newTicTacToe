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
        Game game = new Game(board, validation, rules, playerOne, playerTwo);
        AbstractPlayer expectedPlayer = playerOne;
        AbstractPlayer actualPlayer = game.currentPlayer();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void gameSwitchesToNextPlayer() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, validation, rules, playerOne, playerTwo);
        game.turn(1);
        AbstractPlayer expectedPlayer = playerTwo;
        AbstractPlayer actualPlayer = game.currentPlayer();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void boardMarkedWhenTurnTaken() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, validation, rules, playerOne, playerTwo);
        game.turn(1);
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
        Game game = new Game(board, validation, rules, playerOne, playerTwo);
        game.turn(2);
        game.turn(3);
        String[] expectedBoard = {"1", "X", "O", "4", "5", "6", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }
}