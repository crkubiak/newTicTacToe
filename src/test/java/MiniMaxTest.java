import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class MiniMaxTest {

    @Test
    public void selectsAvailableSquareFromBoardWithOneEmptySquare(){
        String[] testBoard = {
                "X","O","3",
                "X","5","6",
                "7","8","9"
        };
        Board board = new Board(testBoard);
        MiniMax miniMax = new MiniMax(board);

        int expectedMove = 6;
        int actualMove = miniMax.chooseMove();

        assertEquals(expectedMove, actualMove);
    }

    @Test
    public void determineCurrentPlayer() {
        String[] testBoard = {
                "X","O","X",
                "O","X","6",
                "7","8","O"
        };
        Board board = new Board(testBoard);
        MiniMax miniMax = new MiniMax(board);
        miniMax.chooseMove();

        String expectedMaximizer = "X";
        String expectedMinimizer = "O";
        String actualMaximizer = miniMax.getMaximizer();
        String actualMinimizer = miniMax.getMinimizer();

        assertEquals(expectedMaximizer, actualMaximizer);
        assertEquals(expectedMinimizer, actualMinimizer);
    }
}
