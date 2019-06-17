import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {

    @Test
    public void testPlayerConversion() {
        Rules rules = new Rules();
        String currentPlayer = "X";
        Integer[] expectedBoard = {1,2,3,0,0,0,0,0,0};
        String[] board = {"X","X","X","O","O","6","7","8","9"};
        assertArrayEquals(expectedBoard, rules.playerConversion(board, currentPlayer));
    }

    @Test
    public void testVictoryCheck() {

        Rules rules = new Rules();
        String currentPlayer = "X";
        String[] board = {"X","X","X","O","O","6","7","8","9"};

        String expectedPlayer = "X";
        String actualPlayer = rules.victoryCheck(board, currentPlayer);

        assertEquals(expectedPlayer, actualPlayer);
    }
}