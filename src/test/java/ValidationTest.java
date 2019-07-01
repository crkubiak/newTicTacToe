import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void testMoveIsInRange() {
        Board board = new Board();
        Validation validation = new Validation();
        assertTrue(validation.validate(1, board));
        assertTrue(validation.validate(9, board));
        assertFalse(validation.validate(0, board));
        assertFalse(validation.validate(10, board));
    }

    @Test
    public void testMoveIsAvailable() {
        Board board = new Board();
        Rules rules = new Rules();
        Validation validation = new Validation();
        Player playerOne = new Human();
        Player playerTwo = new RandomComputer();
        Game game = new Game(board, validation, rules, playerOne, playerTwo);
        game.move(5);
        assertTrue(validation.validate(3, board));
        assertFalse(validation.validate(5, board));
    }
}