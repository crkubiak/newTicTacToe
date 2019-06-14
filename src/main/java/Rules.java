public class Rules {

    private boolean gameWon = false;
    private Integer[] currentPlayersBoard = {0,0,0,0,0,0,0,0,0};
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

    public boolean victoryCheck(String[] board, String currentPlayer) {
        Integer[] boardToCheck = playerConversion(board, currentPlayer);

    }

    private Integer[] playerConversion(String[] board, String currentPlayer) {

        for (int i = 0; i < board.length; i++) {
            if (board[i] == currentPlayer) {
                currentPlayersBoard[i] = i + 1;
            }
        }
        return currentPlayersBoard;
    }
}
