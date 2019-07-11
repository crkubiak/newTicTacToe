import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MiniMax2Test {
    @Test
    public void blankBoardPassedIntoMM2() {
        Board board = new Board();
        Validation validation = new Validation();
        Rules rules = new Rules();
        MiniMax2 mm = new MiniMax2(board);
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new MiniMaxComputer(mm);

        Game game = new Game(board, rules, validation, playerOne, playerTwo);

        String[] expected = {"1","2","3","4","5","6","7","8","9"};
        String[] actual = mm.returnBoard();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBoardPassedIntoMM2() {
        String[] testBoard = {"X","2","3","4","5","6","7","8","9"};
        Board board = new Board(testBoard);
        Validation validation = new Validation();
        Rules rules = new Rules();
        MiniMax2 mm = new MiniMax2(board);
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new MiniMaxComputer(mm);

        Game game = new Game(board, rules, validation, playerOne, playerTwo);

        String[] expected = testBoard;
        String[] actual = mm.returnBoard();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPlayerOneTurnCanBeDeterminedByMM() {
        String[] testBoard = {"1","2","3","4","5","6","7","8","9"};
        Board board = new Board(testBoard);
        Validation validation = new Validation();
        Rules rules = new Rules();
        MiniMax2 mm = new MiniMax2(board);
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new MiniMaxComputer(mm);

        Game game = new Game(board, rules, validation, playerOne, playerTwo);

        String expectedMarker = "X";
        String actualMaker = mm.currentPlayer();

        assertEquals(expectedMarker, actualMaker);
    }

    @Test
    public void testPlayerTwoTurnCanBeDeterminedByMM() {
        String[] testBoard = {"X","2","3","4","5","6","7","8","9"};
        Board board = new Board(testBoard);
        Validation validation = new Validation();
        Rules rules = new Rules();
        MiniMax2 mm = new MiniMax2(board);
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new MiniMaxComputer(mm);

        Game game = new Game(board, rules, validation, playerOne, playerTwo);

        String expectedMarker = "O";
        String actualMaker = mm.currentPlayer();

        assertEquals(expectedMarker, actualMaker);
    }
    @Test
    public void mm2CanCalculateAvailableSquares() {
        String[] testBoard = {"X","O","X","4","5","6","7","8","O"};
        Board board = new Board(testBoard);
        Validation validation = new Validation();
        Rules rules = new Rules();
        MiniMax2 mm = new MiniMax2(board);
        AbstractPlayer playerOne = new Human();
        AbstractPlayer playerTwo = new MiniMaxComputer(mm);

        Game game = new Game(board, rules, validation, playerOne, playerTwo);


        List<String> expected = new ArrayList<>();
                expected.add("4");
                expected.add("5");
                expected.add("6");
                expected.add("7");
                expected.add("8");
        List<String> actual = mm.getAvailableSquares();
        assertEquals(expected, actual);
    }
}