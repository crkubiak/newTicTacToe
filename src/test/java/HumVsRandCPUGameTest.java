import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumVsRandCPUGameTest {

    @Test
    public void gameStartsWithPlayerX() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        HumVsRandCPUGame humVsRandCPUGame = new HumVsRandCPUGame(board, validation, rules);
        String expectedPlayer = "X";
        String actualPlayer = humVsRandCPUGame.currentPlayer();
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void gameSwitchesToNextPlayer() {
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        HumVsRandCPUGame humVsRandCPUGame = new HumVsRandCPUGame(board, validation, rules);
        humVsRandCPUGame.move(1);
        String expectedPlayer = "O";
        String actualPlayer = humVsRandCPUGame.currentPlayer();
        assertEquals(expectedPlayer, actualPlayer);
    }
}