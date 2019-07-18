import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MiniMaxComputerTest {
    @Test
    public void testMakeLastMoveOnBoard() {
        String[] testBoard = {
                "X", "X", "X",
                "O", "O", "X",
                "X", "O", "9"};
        Board board = new Board(testBoard);
        Rules rules = new Rules();
        Validation validation = new Validation();
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new MiniMaxComputer();
        Game game = new Game(board, rules, validation, playerOne, playerTwo);

        int expectedTurn = 9;
        int actualTurn = playerTwo.takeTurn(board);
        game.move(actualTurn);

        String[] expectedBoard = {
                "X", "X", "X",
                "O", "O", "X",
                "X", "O", "O"};
        System.out.println(Arrays.toString(board.currentMoves()));
        String[] actualBoard = board.currentMoves();

        assertEquals(expectedTurn, actualTurn);
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testMakeWinningLookAheadOfOneMove() {
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        Board board = new Board(testBoard);
        MiniMax mm = new MiniMax(board);
        Player mmc = new MiniMaxComputer();

        int expected = 9;
        int actual = mmc.takeTurn(board);
        assertEquals(expected, actual);
    }

}