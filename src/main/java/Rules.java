public class Rules {

    private boolean gameWon = false;
    private Integer[] currentPlayersBoard = {0,0,0,0,0,0,0,0,0};
    private int[][] winningBoards = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    //        String[][] winningBoards = {
//                {"1","2","3"},
//                {"4","5","6"},
//                {"7","8","9"},
//                {"1","4","7"},
//                {"2","5","8"},
//                {"3","6","9"},
//                {"1","5","9"},
//                {"3","5","7"}
//        };
//    public boolean victory(String[] board) {
//
//
//    }

    public Integer[] playerConversion(Board board, Game game) {

        for (int i = 0; i < board.currentBoard.length; i++) {
            if (board.currentBoard[i] == game.markers[game.turnCount % 2]) {
                currentPlayersBoard[i] = i + 1;
            }
        }

        return currentPlayersBoard;


    }


}
