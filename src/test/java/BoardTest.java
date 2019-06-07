import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void canICreateBoard() {
        Board board = new Board();
        String[] expectedBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

    @Test
    public void itLetsPlayerXMakeAMove() {
        Board board = new Board();
        board.move(1, "X");
        String[] expectedBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

    @Test
    public void itLetsPlayerOMakeAMove() {
        Board board = new Board();
        board.move(2, "O");
        String[] expectedBoard = {"1", "O", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

    @Test
    public void playersCanEachMakeAMove() {
        Board board = new Board();
        board.move(5,"X");
        board.move(8, "O");
        String[] expectedBoard = {"1", "2", "3", "4", "X", "6", "7", "O", "9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

}