import java.util.Arrays;
import java.util.HashSet;

public class Rules {

    private String playerWon = "";
    private Integer[] currentPlayersBoard = {0,0,0,0,0,0,0,0,0};
    private HashSet<Integer> victorySet = new HashSet<>();
    private Integer[][] winningBoards = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };

    public String victoryCheck(String[] board, String currentPlayer) {
        Integer[] boardToCheck = playerConversion(board, currentPlayer);
        for (int game = 0; game < currentPlayersBoard.length - 1; game++) {
            victorySet.addAll(Arrays.asList(boardToCheck));
            victorySet.retainAll(Arrays.asList(winningBoards[game]));
            if (victorySet.size() == 3) {
                playerWon = currentPlayer;
            }
        }
        System.out.println("Player "+ playerWon + " won!");
        return playerWon;
    }

    public Integer[] playerConversion(String[] board, String currentPlayer) {

        for (int i = 0; i < board.length; i++) {
            if (board[i] == currentPlayer) {
                currentPlayersBoard[i] = i + 1;
            }
        }
        return currentPlayersBoard;
    }
}
