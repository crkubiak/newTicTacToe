import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class MiniMaxTest {

    @Test
    public void selectsAvailableSquareFromBoardWithOneEmptySquare(){
        String[] testBoard = {
//                "X","O","3",
//                "X","5","6",
//                "7","8","9"
                "X","X","O",
                "X","O","X",
                "7","8","O"
        };
        Board board = new Board(testBoard);
        MiniMax miniMax = new MiniMax(board);

        int expectedMove = 6;
        int actualMove = miniMax.chooseMove();

        assertEquals(expectedMove, actualMove);
    }

//    @Test
//    public void determineCurrentPlayer() {
//        String[] testBoard = {
//                "X","O","X",
//                "O","X","6",
//                "7","8","O"
//        };
//        Board board = new Board(testBoard);
//        MiniMax miniMax = new MiniMax(board);
//        miniMax.chooseMove();
//
//        String expectedCurrentPlayer = "X";
//        String expectedOpponentPlayer = "O";
//        String actualCurrentPlayer = miniMax.currentPlayer;
//        String actualOpponentPlayer = miniMax.opponentPlayer;
//
//        assertEquals(expectedCurrentPlayer, actualCurrentPlayer);
//        assertEquals(expectedOpponentPlayer, actualOpponentPlayer);
//
//    }
}
//    @Test
//    public void testMinPlayerXWinReturnsNegative10() {
//        String[] testBoard = {"X", "X", "X", "O", "5", "6", "O", "8", "9"};
//        Board board = new Board(testBoard);
//        MiniMax mm = new MiniMax(board);
//
//        mm.miniMax(testBoard, "X");
//        int expectedWin = -10;
//        int actualWin = mm.score;
//
//        assertEquals(expectedWin, actualWin);
//    }
//
//    @Test
//    public void testMaxPlayerOWinReturns10() {
//        String[] testBoard = {"O", "O", "O", "X", "5", "6", "X", "8", "X"};
//        Board board = new Board(testBoard);
//        MiniMax mm = new MiniMax(board);
//
//        mm.miniMax(testBoard, mm.aiPlayer);
//        int expectedWin = 10;
//        int actualWin = mm.score;
//
//        assertEquals(expectedWin, actualWin);
//    }
//
//    @Test
//    public void testFullBoardReturns0() {
//        String[] testBoard = {"X", "O", "X", "O", "O", "X", "O", "X", "O"};
//        Board board = new Board(testBoard);
//
//        MiniMax mm = new MiniMax(board);
//
//        mm.miniMax(testBoard, mm.aiPlayer);
//        int expectedWin = 0;
//        int actualWin = mm.score;
//
//        assertEquals(expectedWin, actualWin);
//    }
//}

    //    @Test
//    public void testGetProxyBoard() {
//        String[] testBoard = {"X", "O", "3", "4", "5", "6", "7", "8", "9"};
//        Board board = new Board(testBoard);
//        Validation validation = new Validation();
//        Rules rules = new Rules();
//        MiniMax mm = new MiniMax(board);
//        AbstractPlayer playerOne = new Human();
//        AbstractPlayer playerTwo = new MiniMaxComputer();
//
//        Game game = new Game(board, rules, validation, playerOne, playerTwo);
//
//        String[] expectedBoard = board.currentMoves();
//        String[] actualBoard = ;
//
//        assertArrayEquals(expectedBoard, actualBoard);
//    }

//    @Test
//    public void testProxyVictoryCheckNoVictory() {
//        String[] proxyBoard = {"X", "O", "3", "4", "5", "6", "7", "8", "9"};
//        Board board = new Board(proxyBoard);
//        Validation validation = new Validation();
//        Rules rules = new Rules();
//        MiniMax mm = new MiniMax(board);
//        AbstractPlayer playerOne = new Human();
//        AbstractPlayer playerTwo = new MiniMaxComputer();
//
//        Game game = new Game(board, rules, validation, playerOne, playerTwo);

//        String expectedPlayerVictory = "";
//        String actualMaximizingPlayerVictory = mm.proxyVictoryCheck(mm.maximizingPlayer);
//        String actualMinimizingPlayerVictory = mm.proxyVictoryCheck(mm.minimizingPlayer);

//        assertEquals(expectedPlayerVictory, actualMaximizingPlayerVictory);
//        assertEquals(expectedPlayerVictory, actualMinimizingPlayerVictory);
//    }
    //
//    @Test
//    public void testNoOneHasWonReturns0() {
//        String[] testBoard = {"X", "O", "X", "X", "O", "O", "O", "X", "O"};
//        Board board = new Board(testBoard);
//        Validation validation = new Validation();
//        Rules rules = new Rules();
//        MiniMax mm = new MiniMax(board);
//        AbstractPlayer playerOne = new Human();
//        AbstractPlayer playerTwo = new MiniMaxComputer();
//
//        Game game = new Game(board, rules, validation, playerOne, playerTwo);
//
//        int expectedWin = 0;
//        int actualWin =  mm.miniMax(0, mm.getMaximizingPlayer());
//
//        assertEquals(expectedWin, actualWin);
//    }
//

//    @Test
//    public void miniMaxCanEvaluateMaxWon() {
//        String[] testBoard = {"X","X","X","O","5","6","7","O","O"};
//        Board board = new Board(testBoard);
//        MiniMax mm = new MiniMax(board);
//        Rules rules = new Rules();
//        int depth = 0;
//
//        int expected = 10;
//        int actual = mm.evalute(depth);
//
//    }
    //    @Test
//    public void miniMaxReturnsScoreofANodeWithNoChild() {
//        Board board = new Board();
//        Node node = new Node(5);
//        MiniMax mm = new MiniMax(board);
//
//        int expectedScore = 5;
//        int actualScore = mm.score(node);
//
//        assertEquals(expectedScore, actualScore);
//    }
//
//    @Test
//    public void miniMaxReturnsScoreOfANodeWithOneChild() {
//        Board board = new Board();
//        Node child = new Node(10);
//        ArrayList<Node> childToParent = new ArrayList<>();
//        childToParent.add(child);
//        Node parent = new Node(childToParent);
//        MiniMax mm = new MiniMax(board);
//
//        int expectedScore = 10;
//        int actualScore = mm.score(parent);
//
//        assertEquals(expectedScore, actualScore);
//    }
//
//    @Test
//    public void miniMaxReturnsScoreOfLinkedList() {
//        Board board = new Board();
//        Node child = new Node(21);
//        ArrayList<Node> childToParent = new ArrayList<>();
//        childToParent.add(child);
//        Node parent = new Node(childToParent);
//        ArrayList<Node> parentToGrandParent = new ArrayList<>();
//        parentToGrandParent.add(parent);
//        Node grandParent = new Node(parentToGrandParent);
//        MiniMax mm = new MiniMax(board);
//
//        int expectedScore = 21;
//        int actualScore = mm.score(grandParent);
//
//        assertEquals(expectedScore, actualScore);
//    }
//
//    @Test
//    public void miniMaxReturnsLargestOfTwoChildren() {
//        Board board = new Board();
//        Node child1 = new Node(12);
//        Node child2 = new Node(27);
//        ArrayList<Node> children = new ArrayList<>();
//        children.add(child1);
//        children.add(child2);
//        Node parent = new Node(children);
//        MiniMax mm = new MiniMax(board);
//
//        int expectedScore = 27;
//        int actualScore = mm.score(parent);
//
//        assertEquals(expectedScore, actualScore);
//    }
//
//    @Test
//    public void miniMaxReturnsSmallestGrandChild() {
//        Board board = new Board();
//        Node child1 = new Node(-12);
//        Node child2 = new Node(402);
//        ArrayList<Node> childToParent = new ArrayList<>();
//        childToParent.add(child1);
//        childToParent.add(child2);
//        Node parent = new Node(childToParent);
//        ArrayList<Node> parentToGrandParent = new ArrayList<>();
//        parentToGrandParent.add(parent);
//        Node grandParent = new Node(parentToGrandParent);
//        MiniMax mm = new MiniMax(board);
//
//        int expectedValue = -12;
//        int actualValue = mm.score(grandParent);
//
//        assertEquals(expectedValue, actualValue);
//    }
