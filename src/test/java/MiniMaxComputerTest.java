import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MiniMaxComputerTest {
    @Test
    public void miniMaxTakesCornerOnFirstMove() {
        String[] testBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board(testBoard);
        Player mmc = new MiniMaxComputer();

        int expected = 1;
        int actual = mmc.takeTurn(board);
        assertEquals(expected, actual);
    }

    @Test
    public void miniMaxTakesCenterOnSecondMove() {
        String[] testBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        Board board = new Board(testBoard);
        Player mmc = new MiniMaxComputer();

        int expected = 5;
        int actual = mmc.takeTurn(board);
        assertEquals(expected, actual);
    }

    @Test
    public void miniMaxWillBlock() {
        String[] testBoard = {"X", "2", "O", "X", "5", "6", "7", "8", "9"};
        Board board = new Board(testBoard);
        Player mmc = new MiniMaxComputer();

        int expected = 7;
        int actual = mmc.takeTurn(board);
        assertEquals(expected, actual);
    }

}

