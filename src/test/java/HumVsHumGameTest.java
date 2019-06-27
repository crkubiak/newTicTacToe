import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void gameStartsWithPlayerX() {

        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        Game game = new Game(board, validation, rules);
        assertEquals("X", game.currentPlayer());
    }

    @Test
    public void gameSwitchesToNextPlayer() {
        Validation validation =new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        Game game = new Game(board, validation, rules);
        game.move(1);
        assertEquals("O", game.currentPlayer());
    }

    @Test
    public void boardMarkedWhenTurnTaken() {
        Validation validation =new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        Game game = new Game(board, validation, rules);
        game.move(1);
        String[] expectedBoard = {"X","2","3","4","5","6","7","8","9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

    @Test
    public void multipleTurnsMarkedOnBoard() {
        Validation validation =new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        Game game = new Game(board, validation, rules);

        game.move(4);
        game.move(6);
        String[] expectedBoard = {"1","2","3","X","5","O","7","8","9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }

//    @Test
//    public void testPlayerTypeHuman() {
//        Validation validation = new Validation();
//        Board board = new Board();
//        Rules rules = new Rules();
//        Game game = new Game(board, validation, rules);
//        String expectedPlayerType = "Human";
//        String actualPlayerType = game.playerType("h");
//        assertEquals(expectedPlayerType, actualPlayerType);
//    }
//
//    @Test
//    public void testPlayerTypeRandomComputer() {
//        Validation validation = new Validation();
//        Board board = new Board();
//        Rules rules = new Rules();
//        Game game = new Game(board, validation, rules);
//        String expectedPlayerType = "Random Computer";
//        String actualPlayerType = game.playerType("r");
//        assertEquals(expectedPlayerType, actualPlayerType);
//    }
}