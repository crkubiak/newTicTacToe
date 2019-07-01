import org.junit.Test;

import static org.junit.Assert.*;

public class RandomComputerTest {
    @Test
    public void testTakeTurn() {
        Player rc = new RandomComputer("O");
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        Board board = new Board(testBoard);
        int expected = 9;
        int actual = rc.takeTurn(board);
        assertEquals(expected, actual);
    }
}