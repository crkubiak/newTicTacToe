import org.junit.Test;

import static org.junit.Assert.*;

public class MiniMaxComputerTest {
    @Test
    public void testReturnIntFromTakeTurn() {
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        Board board = new Board(testBoard);
        MiniMax2 mm = new MiniMax2(board);
        Player mmc = new MiniMaxComputer(mm);

        int expected = 9;
        int actual = mmc.takeTurn(board);
        assertEquals(expected, actual);
    }

}