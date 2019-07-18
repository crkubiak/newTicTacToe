public class MiniMax {
    private final Board board;
//    String currentPlayer;
//    String opponentPlayer;
    Rules rules = new Rules();
    String maximizer;
    String minimizer;

    public MiniMax(Board board) {
        this.board = board;
        maximizer = "O";
        minimizer = "X";
    }

    private Integer evalBoard(int depth) {
        final int WINNING_SCORE = 10;
        final int LOSING_SCORE = -10;
        final int DRAW_SCORE = 0;
        if (rules.victoryCheck(board.currentMoves(), maximizer) == maximizer){
            return WINNING_SCORE - depth;
        }
        if (rules.victoryCheck(board.currentMoves(), minimizer) == minimizer) {
            return LOSING_SCORE + depth;
        }
        return DRAW_SCORE;
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

    public Integer chooseMove() {
        int bestValue = Integer.MIN_VALUE;
        int bestIndex = Integer.MIN_VALUE;
//        currentPlayer();
        for (int space : board.availableSpaces()) {

            board.markBoard(space + 1, maximizer);
            int moveValue = miniMax(0, false);
            board.markBoard(space + 1, Integer.toString(space + 1));
            if (moveValue > bestValue) {
                bestValue = moveValue;
                bestIndex = space;
            }
        }
        return bestIndex;
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

