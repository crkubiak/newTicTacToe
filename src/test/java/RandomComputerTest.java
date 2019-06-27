import org.junit.Test;

import static org.junit.Assert.*;

public class RandomComputerTest {
    @Test
    public void testGetMarker() {
        RandomComputer rc = new RandomComputer();
        String expectedMarker = "X";
        String actualMarker = rc.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    public void testSetMarker() {
        RandomComputer rc = new RandomComputer();
        String expectedMarker = "O";
        rc.setMarker("O");
        String actualMarker = rc.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    public void testTakeTurn() {
        RandomComputer rc = new RandomComputer();
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        Board board = new Board(testBoard);
        int expected = 8;
        int actual = rc.takeTurn(board);
        assertEquals(expected, actual);
    }
}