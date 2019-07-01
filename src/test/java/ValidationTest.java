import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ValidationTest {
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

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
        AbstractPlayer playerOne = new Human("X");
        AbstractPlayer playerTwo = new RandomComputer("O");
        Game game = new Game(board, validation, rules, playerOne, playerTwo);
        game.turn(5);
        assertTrue(validation.validate(3, board));
        assertFalse(validation.validate(5, board));
    }
}