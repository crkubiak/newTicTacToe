import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MiniMax {
    private final Board board;
//    String currentPlayer;
//    String opponentPlayer;
    Rules rules = new Rules();
    String maximizer = "O";
    String minimizer = "X";

    public MiniMax(Board board) {
        this.board = board;
    }

    private Integer evalBoard(int depth) {
        if (rules.victoryCheck(board.currentMoves(), maximizer) == maximizer){
            return 10 - depth;
        }
        if (rules.victoryCheck(board.currentMoves(), minimizer) == minimizer) {
            return -10 + depth;
        }
        return 0;
    }

    public Integer chooseMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestIndex = Integer.MIN_VALUE;
//        currentPlayer();
        for (int space : board.availableSpaces()) {

            board.markBoard(space + 1, maximizer);
            int score = miniMax(0, false);
            System.out.println("Score: " + score + " Index: " + space);
            board.markBoard(space + 1, Integer.toString(space + 1));
            if (score > bestScore) {
                bestScore = score;
                bestIndex = space;
            }
        }
        return bestIndex;
    }

    private Integer miniMax(int depth, boolean isMax) {
        int score = evalBoard(depth);
        if (score != 0) {
            return score;
        }
        if (board.availableSpaces().isEmpty()) {
            return 0;
        }
        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int square : board.availableSpaces()) {
                board.markBoard(square + 1, maximizer);
                best = Integer.max(best, miniMax(depth +1, false));
                board.markBoard(square + 1, Integer.toString(square + 1));
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int square : board.availableSpaces()) {
                board.markBoard(square + 1, minimizer);
                best = Integer.min(best, miniMax(depth + 1, true));
                board.markBoard(square + 1, Integer.toString(square + 1));
            }
            return best;
        }
    }

    public void currentPlayer() {
        int xCount = 0;
        int oCount = 0;
        for (int square = 0; square < board.currentMoves().length; square++) {
            if(board.currentMoves()[square] == "X") {
                xCount += 1;
            } else if (board.currentMoves()[square] == "O"){
                oCount += 1;
            }
        }
//        currentPlayer = xCount == oCount ? "X" : "O";
//        opponentPlayer = currentPlayer == "X" ? "O" : "X";

    }
}

//    public int chooseMove() {
//        int bestScore = -100;
//        int bestIndex = 0;
//        currentPlayer();
//        for (int space : board.availableSpaces()) {
//            int score;
//            board.markBoard(space + 1, currentPlayer);
//            if (space == 6) {
//                score = 10;
//            } else {
//                score = -10;
//            }
//            board.markBoard(space + 1, Integer.toString(space + 1));
//            if (score > bestScore) {
//                bestScore = score;
//                bestIndex = space;
//            }
//        }









//    String[] originalBoard;
//    Board board;
//    String aiPlayer = "O";
//    String humanPlayer = "X";
//    Rules rules = new Rules();
//    List<Integer> availableCells;
//    int score;
//
//    int functionCall = 0;
//
//    public MiniMax(Board board) {
//        this.board = board;
//        originalBoard = board.currentMoves();
//
//    }
//
//    public String proxyVictoryCheck(String[] newBoard, String currentPlayer) {
//        return rules.victoryCheck(newBoard, currentPlayer);
//    }
//
//    public ArrayList<Integer> availableSpaces(String[] currentBoard) {
//        ArrayList<Integer> available = new ArrayList<>();
//        for (int space = 0; space < currentBoard.length; space++) {
//            if (!currentBoard[space].equals("X") && !currentBoard[space].equals("O")) {
//                available.add(space);
//            }
//        }
//        return available;
//    }
//
//    public int miniMax(String[] newBoard, String player) {
//        functionCall += 1;
//
//        List<Integer> availableCells = availableSpaces(newBoard);
//
//        String didAIWin = proxyVictoryCheck(newBoard, aiPlayer);
//        String didHumanWin = proxyVictoryCheck(newBoard, humanPlayer);
//
//        if (didAIWin.equals(aiPlayer)) {
//             return score = 10;
//        }
//
//        if (didHumanWin.equals(humanPlayer)) {
//            return score = -10;
//        }
//
//        if (availableCells.isEmpty()) {
//            return score =  0;
//        }
//
//        HashMap<Integer, Integer> moves = new HashMap<>();
//
//        for (int i = 0; i < availableCells.size(); i++) {
//
//            //create key
//            int moveIndex = availableCells.get(i);
//
//            //mark proxyBoard w/current player
//            newBoard[availableCells.get(i)] = player;
//
//            int moveScore;
//
//            if (player.equals(aiPlayer)) {
//                int result = miniMax(newBoard, humanPlayer);
//                moveScore = result;
//            } else {
//                int result = miniMax(newBoard, aiPlayer);
//                moveScore = result;
//            }
//
//            newBoard[availableCells.get(i)] = Integer.toString(moveIndex + 1);
//            moves.put(moveIndex, moveScore);
//        }
//        int bestMove = 0;
//        if (player == aiPlayer) {
//            int bestScore = -10000;
//            for (int i = 0; i < moves.size(); i++) {
//                if (moves.get(i) > bestScore) {
//                    bestScore = moves.get(i);
//                    bestMove = i;
//                }
//            }
//        } else {
//            int bestScore = 10000;
//            for (int i = 0; i <moves.size(); i++) {
//                if(moves.get(i) < bestScore) {
//                    bestScore = moves.get(i);
//                    bestMove = i;
//                }
//            }
//        }
//        return moves.get(bestMove);
//    }
//
//
//    public int getBestSpot() {
//        int bestSpot = miniMax(board.currentMoves(), aiPlayer);
//        return bestSpot;
//    }
//}


    //    private String maximizingPlayer = "O";
//    private String minimizingPlayer = "X";
//    private String noPlayer = "";
//    private Board mmBoard;
//    private Rules rules;
//    String turn = maximizingPlayer;
//    int computerMove;
//    String[] proxyBoard;
//
//    public MiniMax(Board board) {
//            this.mmBoard = board;
//            rules = new Rules();
//    }
//
//    String getMaximizingPlayer() {
//            return maximizingPlayer;
//    }
//
//    String getMinimizingPlayer() {
//            return minimizingPlayer;
//    }
//
//    void setProxyBoard() {
//        proxyBoard = mmBoard.currentMoves();
//    }
//
//    int miniMax(int depth, String turn) {
//        String didMaxWin = rules.victoryCheck(proxyBoard, maximizingPlayer);
//        String didMinWin = rules.victoryCheck(proxyBoard, minimizingPlayer);
//        if (didMaxWin == maximizingPlayer) {
//            return 10;
//        }
//
//        if (didMinWin == minimizingPlayer) {
//            return -10;
//        }
//
//        List<Integer> availableCells = mmBoard.availableSpaces();
//
//        if (availableCells.isEmpty()) {
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < availableCells.size(); i++) {
//            if (turn == maximizingPlayer) {
//                proxyBoard[i] = maximizingPlayer;
////                mmBoard.markBoard(i + 1, maximizingPlayer);
//                int currentScore = miniMax(depth + 1, minimizingPlayer);
//                max = Math.max(currentScore, max);
//                if (currentScore >= 0) {
//                    if (depth == 0) {
//                        computerMove = i;
//                    }
//                }
//
//                if (currentScore == 10) {
//                    availableCells.set(i, 0);
//                    break;
//                }
//
//                if (i == availableCells.size() - 1 && max < 0) {
//                    if (depth == 0) {
//                        computerMove = i;
//                    }
//                }
//            } else if (turn == minimizingPlayer) {
//                proxyBoard[i] = minimizingPlayer;
////                mmBoard.markBoard(i + 1, minimizingPlayer);
//                int currentScore = miniMax(depth + 1, maximizingPlayer);
//                min = Math.min(currentScore, min);
//
//                if (min == -10) {
//                    availableCells.set(i, 0);
//                    break;
//                }
//            }
//            availableCells.set(i, 0);
//        }
//        System.out.println(computerMove);
//        return turn == maximizingPlayer ? max : min;
//    }
//
//    int decision() {
//        setProxyBoard();
//        miniMax(0, maximizingPlayer);
//        return computerMove;
//    }
//}
//    int emptySqaure = 0;
//    String maximizer;
//    String minimizer;
//    Board board;
//    Rules rules;
//
//
//    public MiniMax(Board board) {
//        this.board = board;
//        rules = new Rules();
//    }
//
//    String currentPlayer() {
//        int xCount = 0;
//        for (int square = 0; square < board.currentMoves().length; square++) {
//            if(board.currentMoves()[square] == "X") {
//                xCount += 1;
//            }
//        }
//        if (xCount % 2 == 0) {
//            return maximizer = "O";
//        } else {
//            return maximizer = "X";
//        }
//    }
//
//    int evaluate(int depth) {
//        if(rules.victoryCheck(board.currentMoves(), maximizer) == "X") {
//            return 10;
//        }
//
//        if(rules.victoryCheck(board.currentMoves(), minimizer) == "O") {
//            return -10;
//        }
//
//        return 0;
//    }
//
//    int miniMax(int depth, boolean isMax) {
//        int score = evaluate(depth);
//
//        if (score != 0) {
//            return score;
//        }
//
//        if (board.availableSpaces().size() == 0) {
//            return 0;
//        }
//
//        if (isMax) {
//            int best = Integer.MIN_VALUE;
//
//            for (int index : board.availableSpaces()) {
//                board.markBoard(index, maximizer);
//                best = Integer.max(best, miniMax(depth + 1, false));
//                board.markBoard(index + 1, Integer.toString(index));
//            }
//            return best;
//        } else {
//            int best = Integer.MAX_VALUE;
//
//            for (int index : board.availableSpaces()) {
//                board.markBoard(index, minimizer);
//                best = Integer.min(best, miniMax(depth + 1, true));
//                board.markBoard(index + 1, Integer.toString(index));
//            }
//            return best;
//        }
//    }
//
//    public int decision() {
//        int bestValue = Integer.MIN_VALUE;
//        int bestIndex = Integer.MIN_VALUE;
//        currentPlayer();
//
//        for (int index: board.availableSpaces()) {
//            board.markBoard(index + 1, maximizer);
//            int moveValue = miniMax(0, false);
//            board.markBoard(index + 1, Integer.toString(index));
//
//            if(moveValue > bestValue) {
//                bestValue = moveValue;
//                bestIndex = index;
//            }
//        }
//        return bestIndex + 1;
//    }
//}
