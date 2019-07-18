import java.util.HashMap;
import java.util.Map;

public class MiniMax2 {
//    Board board;
//    Rules rules;
//    String humanPlayer = "X";
//    String aiPlayer = "O";
//    String currentPlayer = aiPlayer;
//    String opponent = humanPlayer;
//
//    public MiniMax2(Board board) {
//        this.board = board;
//    }
//
//    public int chooseSpace(Board board) {
//        return calculateBestMove(board, 0, new HashMap<>());
//    }
//
//    private int calculateBestMove(Board board, int depth, Map<Integer, Integer> potentialOutComes) {
//
//        int TIEDGAME = 0;
//        int humanWin = -1;
//        int aiWin = 1;
//        String didAIWin = rules.victoryCheck(board.curre` `, aiPlayer);
//        String didHumanWin = rules.victoryCheck(board.currentMoves(), humanPlayer);
//
//        if (board.availableSpaces(board.currentMoves()).size() == 0) {
//            return TIEDGAME;
//        } else if (didAIWin == aiPlayer) {
//            return aiWin;
//        } else if (didHumanWin == humanPlayer) {
//            return humanWin;
//        } else {
//            checkPossibilities(board, depth, potentialOutComes);
//            if (depth == 0) {
//                return getBestMove(potentialOutComes);
//            } else {
//                return getTopScore(potentialOutComes);
//            }
//        }
//    }
//
//    private void checkPossibilities(Board board, int depth, Map<Integer, Integer> potentionalOutcomes) {
//        for (int space : board.availableSpaces(board.currentMoves())) {
//            emulateTurn(board, space);
//            addPossibilityToOutcomes(board, depth, potentionalOutcomes, space);
//            resetBoard(board, space);
//        }
//    }
//
//    private void emulateTurn(Board board, int space) {
//        board.markBoard(space, currentPlayer);
//        changeCurrentPlayer();
//    }
//
//    private void addPossibilityToOutcomes(Board board, int depth, Map<Integer, Integer> potentialOutcomes, int space) {
//        potentialOutcomes.put(space, (-1 * calculateBestMove(board, depth + 1, new HashMap<>())));
//    }
//
//    private void resetBoard(Board board, int space) {
//        board.markBoard(space, Integer.toString(space)); //possibly + 1
//        changeCurrentPlayer();
//    }
//
//    private int getBestMove(Map<Integer, Integer> bestScore) {
//        return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
//    }
//
//    private int getTopScore(Map<Integer, Integer> bestScore) {
//        return bestScore.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
//    }
//
//    private void changeCurrentPlayer() {
//        if (currentPlayer == aiPlayer) {
//            currentPlayer = humanPlayer;
//        } else {
//            currentPlayer = aiPlayer;
//        }
//    }
//

}

