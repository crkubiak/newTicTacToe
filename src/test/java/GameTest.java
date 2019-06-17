import org.junit.Test;

import static org.junit.Assert.*;

class MockIO extends IO {

}
public class GameTest {

    @Test
    public void gameStartsWithPlayerX() {
        MockIO mockIO = new MockIO();
        Validation validation = new Validation();
        Board board = new Board();
        Rules rules = new Rules();
        Game game = new Game(board, validation, rules);
        assertEquals("X", game.currentPlayer());
        assertEquals("Invalid move!", mockIO.invalidMoveIO());
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
        game.move(4);//note
        game.move(6);
        String[] expectedBoard = {"1","2","3","X","5","O","7","8","9"};
        assertArrayEquals(expectedBoard, board.currentMoves());
    }


//    @Test
//    public void testPlayGame() {
//        Validation validation =new Validation();
//        Board board = new Board();
//        Game game = new Game(board, validation);
//        game.playGame();
//    }
}