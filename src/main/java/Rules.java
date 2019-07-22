import java.util.Arrays;
import java.util.HashSet;

public class Rules {
    private boolean didPlayerWin;
    private Integer[] currentPlayersBoard = {0,0,0,0,0,0,0,0,0};
    private Integer[][] winningBoards = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {1,4,7},
            {2,5,8},
            {3,6,9},
            {1,5,9},
            {3,5,7}
    };

    boolean didPlayerWin() {
        return didPlayerWin;
    }

    public String victoryCheck(String[] board, String currentPlayer) {
        Integer[] boardToCheck = playerConversion(board, currentPlayer);
        String playerWon ="";
        for (int game = 0; game < currentPlayersBoard.length - 1; game++) {
            HashSet<Integer> victorySet = new HashSet<>(Arrays.asList(boardToCheck));
            victorySet.retainAll(Arrays.asList(winningBoards[game]));
            if (victorySet.size() == 3) {
                playerWon = currentPlayer;
                didPlayerWin = true;
            } else {
                currentPlayersBoard = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
        }
        return playerWon;
    }

    Integer[] playerConversion(String[] board, String currentPlayer) {
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(currentPlayer)) {
                currentPlayersBoard[i] = i + 1;
            }
        }
        return currentPlayersBoard;
    }
}
