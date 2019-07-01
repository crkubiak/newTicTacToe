import org.junit.Test;

import static org.junit.Assert.*;

public class MiniMaxComputerTest {
    @Test
    public void testTakeTurn() {
        Player mmc = new MiniMaxComputer();
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        Board board = new Board(testBoard);
        int expected = 8;
        int actual = mmc.takeTurn(board);
        assertEquals(expected, actual);
    }
}