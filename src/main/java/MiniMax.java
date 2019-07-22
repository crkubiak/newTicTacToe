public class MiniMax {
    private final Board board;
    private Rules rules = new Rules();
    private String maximizer;
    private String minimizer;

    public MiniMax(Board board) {
        this.board = board;
    }

    private Integer evalBoard(int depth) {
        final int WINNING_SCORE = 10;
        final int LOSING_SCORE = -10;
        final int DRAW_SCORE = 0;
        if (rules.victoryCheck(board.currentMoves(), maximizer).equals(maximizer)){
            return WINNING_SCORE - depth;
        } else if (rules.victoryCheck(board.currentMoves(), minimizer).equals(minimizer)) {
            return LOSING_SCORE + depth;
        } else {
            return DRAW_SCORE;
        }
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
                best = Integer.max(best, miniMax(depth + 1, false));
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

    private void currentPlayer() {
        int xCount = 0;
        int oCount = 0;
        for (int square = 0; square < board.currentMoves().length; square++) {
            if(board.currentMoves()[square].equals("X")) {
                xCount += 1;
            } else if (board.currentMoves()[square].equals("O")){
                oCount += 1;
            }
        }
        maximizer = xCount == oCount ? "X" : "O";
        minimizer = maximizer.equals("X") ? "O" : "X";
    }

    public Integer chooseMove() {
        int bestValue = Integer.MIN_VALUE;
        int bestIndex = Integer.MIN_VALUE;
        currentPlayer();
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

    public String getMaximizer() {
        return maximizer;
    }

    public String getMinimizer() {
        return minimizer;
    }
}
