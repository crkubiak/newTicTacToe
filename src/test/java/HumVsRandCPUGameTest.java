import org.junit.Test;

import static org.junit.Assert.*;

public class HumVsRandCPUGameTest {

    @Test
    public void gameStartsWithPlayerX() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        RandomComputer randomComputer = new RandomComputer();
        HumVsRandCPUGame humVsRandCPUGame = new HumVsRandCPUGame(board, validation, rules, randomComputer);
        String expectedPlayer = "X";
        String actualPlayer = humVsRandCPUGame.currentPlayer();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void gameSwitchesToNextPlayer() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        RandomComputer randomComputer = new RandomComputer();
        HumVsRandCPUGame humVsRandCPUGame = new HumVsRandCPUGame(board, validation, rules, randomComputer);
        humVsRandCPUGame.move(1);
        String expectedPlayer = "O";
        String actualPlayer = humVsRandCPUGame.currentPlayer();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void boardMarkedWhenTurnTaken() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        RandomComputer randomComputer = new RandomComputer();
        HumVsRandCPUGame humVsRandCPUGame = new HumVsRandCPUGame(board, validation, rules, randomComputer);
        humVsRandCPUGame.move(1);
        String[] expectedBoard = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void multipleTurnsMarkedOnBoard() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        RandomComputer randomComputer = new RandomComputer();
        HumVsRandCPUGame humVsRandCPUGame = new HumVsRandCPUGame(board, validation, rules, randomComputer);
        humVsRandCPUGame.move(2);
        humVsRandCPUGame.move(3);
        String[] expectedBoard = {"1", "X", "O", "4", "5", "6", "7", "8", "9"};
        String[] actualBoard = board.currentMoves();
        assertArrayEquals(expectedBoard, actualBoard);
    }
}