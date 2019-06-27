import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testCreateBoard() {
        Board actualBoard = new Board();
        String[] expectedBoard = {"1","2","3","4","5","6","7","8","9"};
        assertArrayEquals(expectedBoard, actualBoard.currentMoves());
    }


    @Test
    public void testXMove() {
        Board actualBoard = new Board();
        actualBoard.move(1, "X");
        String[] expectedBoard = {"X","2","3","4","5","6","7","8","9"};
        assertArrayEquals(expectedBoard, actualBoard.currentMoves());
    }

    @Test
    public void testOMove() {
        Board actualBoard = new Board();
        actualBoard.move(2, "O");
        String[] expectedBoard = {"1","O","3","4","5","6","7","8","9"};
        assertArrayEquals(expectedBoard, actualBoard.currentMoves());
    }

    @Test
    public void testXAndOMove() {
        Board actualBoard = new Board();
        actualBoard.move(8, "X");
        actualBoard.move(9, "O");
        String[] expectedBoard = {"1","2","3","4","5","6","7","X","O"};
        assertArrayEquals(expectedBoard, actualBoard.currentMoves());
    }
    @Test
    public void testDisplayBoardFormat() {
        Board board = new Board();
        String expectedBoard = "1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9";
        assertEquals(expectedBoard,board.displayBoard());
    }

    @Test
    public void testAvailableSpaces4Taken() {
        String[] currentBoard = {"O","2","3","X","5","6","7","X","O"};
        Board board = new Board(currentBoard);
        ArrayList<Integer> available = new ArrayList<>(Arrays.asList(1,2,4,5,6));
        assertEquals(available, board.availableSpaces());
    }

    @Test
    public void testAvailableSpaces2Taken() {
        String[] currentBoard = {"1","2","3","4","5","6","7","8","9"};
        Board board = new Board(currentBoard);
        ArrayList<Integer> available = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        assertEquals(available, board.availableSpaces());
    }


}
//`ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));` (edited)