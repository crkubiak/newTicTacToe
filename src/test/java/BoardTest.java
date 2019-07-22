import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void testCreateBoard() {
        Board board = new Board();
        String[] expectedBoard = {"1","2","3","4","5","6","7","8","9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testXMove() {
        Board board = new Board();
        board.markBoard(1, "X");
        String[] expectedBoard = {"X","2","3","4","5","6","7","8","9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testOMove() {
        Board board = new Board();
        board.markBoard(2, "O");
        String[] expectedBoard = {"1","O","3","4","5","6","7","8","9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testXAndOMove() {
        Board board = new Board();
        board.markBoard(8, "X");
        board.markBoard(9, "O");
        String[] expectedBoard = {"1","2","3","4","5","6","7","X","O"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testDisplayBoardFormat() {
        Board board = new Board();
        String expectedBoard = "1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9";
        String actualBoard = board.displayBoard();
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testAvailableSpaces4Taken() {
        String[] currentBoard = {"O","2","3","X","5","6","7","X","O"};
        Board board = new Board(currentBoard);
        ArrayList<Integer> expectedBoard = new ArrayList<>(Arrays.asList(1,2,4,5,6));
        ArrayList<Integer> actualBoard =  board.availableSpaces();
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testAvailableSpaces2Taken() {
        String[] currentBoard = {"1","2","3","4","5","6","7","8","9"};
        Board board = new Board(currentBoard);
        ArrayList<Integer> expectedBoard = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        ArrayList<Integer> actualBoard = board.availableSpaces();
        assertEquals(expectedBoard, actualBoard);
    }
}