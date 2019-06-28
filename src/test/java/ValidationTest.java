import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void testMoveIsInRange() {
        Validation validation = new Validation();
        assertTrue(validation.moveIsInRange(1));
        assertTrue(validation.moveIsInRange(9));
        assertFalse(validation.moveIsInRange(0));
        assertFalse(validation.moveIsInRange(10));
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
        assertTrue(validation.moveIsAvailable(3, board));
        assertFalse(validation.moveIsAvailable(5, board));
    }
}