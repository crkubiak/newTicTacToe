import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void testMoveIsInRange() {
        Validation validation = new Validation();
        Board board = new Board();
        assertTrue(validation.validate(board, 1));
        assertTrue(validation.validate(board, 9));
        assertFalse(validation.validate(board, 0));
        assertFalse(validation.validate(board, 10));
    }

    @Test
    public void testMoveIsAvailable() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new RandomComputer();
        Game game = new Game(board, rules, validation, playerOne, playerTwo);
        game.move(5);
        assertTrue(validation.validate(board, 3));
        assertFalse(validation.validate(board, 5));
    }
}