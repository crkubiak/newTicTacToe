import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {
//    @Test
//    public void testVictory() {
//        String[] expectedBoard = {"X","X","X","O","O","6","7","8","9"};
//        Rules rules = new Rules();
//
//        assertEquals(true, rules.victory(expectedBoard));
//    }
//
//    @Test
//    public void chunksIntoRows() {
//        String[] expectedBoard = {"X","X","X","O","O","6","7","8","9"};
//        String[][] chunkedBoard = {{"X","X","X"},{"O","O","6"},{"7","8","9"}};
//        Rules rules = new Rules();
//
//        assertEquals(chunkedBoard, rules.chunk(expectedBoard));
//    }

    @Test
    public void playerConversion() {
        Validation validation = new Validation();
        Board board = new Board();
        Game game = new Game(board, validation);
        Rules rules = new Rules();
        Integer[] expectedBoard = {0,0,0,4,5,0,0,0,0};
        game.move(1);
        game.move(4);
        game.move(2);
        game.move(5);
        game.move(3);
        assertArrayEquals(expectedBoard, rules.playerConversion(board, game));

    }

}