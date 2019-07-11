import java.util.ArrayList;
import java.util.List;

public class MiniMax2 {
    Rules rules;
    Board board;
    int noPlayer = 0;
    String playerOne = "X";
    String playerTwo = "O";
    String currentPlayer = "";
    int depth = 0;
    int miniMaxMove;

    public MiniMax2(Board board) {
        this.board = board;
    }

    public String[] returnBoard() {
        return board.currentMoves();
    }

    public String currentPlayer() {
        int turnCount = 0;
        for (int square = 0; square < board.currentMoves().length; square++) {
            if(board.currentMoves()[square] == "X") {
                turnCount += 1;
            }
        }
        if (turnCount % 2 == 0) {
            return playerOne;
        } else {
            return currentPlayer = playerTwo;
        }
    }

    public List<String> getAvailableSquares() {
        List<String> availableSquares = new ArrayList<>();
        for (int square = 0; square < board.currentMoves().length; square++) {
            if(board.currentMoves()[square] != "X" &&
            board.currentMoves()[square] != "O") {
                availableSquares.add(board.currentMoves()[square]);
            }
        }
        return availableSquares;
    }

    public int score(int depth, Board board) {
        if (rules.victoryCheck(board.currentMoves(), currentPlayer()) == "X") {
            return 10;
        }

        if (rules.victoryCheck(board.currentMoves(), currentPlayer()) == "O") {
            return -10;
        }

        List<String> availableSquares = getAvailableSquares();

        if (availableSquares.isEmpty()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int square = 0; square < availableSquares.size(); square++) {
            if (currentPlayer() == "X") {
                board.markBoard(Integer.parseInt(availableSquares.get(square)), currentPlayer());
                int currentScore = score(depth + 1, board);
                max = Math.max(currentScore, max);

                if (currentScore >= 0) {
                    if (depth == 0) {
                        miniMaxMove = Integer.parseInt(availableSquares.get(square));
//                        board.markBoard(Integer.parseInt(availableSquares.get(square)), currentPlayer);
                    }
                }
                if (currentScore == 10) {
                    board.markBoard(Integer.parseInt(availableSquares.get(square)), "0");
                    break;
                }

                if (square == availableSquares.size() - 1 && max < 0) {
                    if (depth == 0) {
                        miniMaxMove = Integer.parseInt(availableSquares.get(square));
//                        board.markBoard(Integer.parseInt(availableSquares.get(square)), currentPlayer);
                    }
                }
            } else if (currentPlayer() == "O") {
                int currentScore = score(depth + 1, board);
                min = Math.min(currentScore, min);

                if (min == -10) {
                    board.markBoard(Integer.parseInt(availableSquares.get(square)), "0");
                    break;
                }
            }
            board.markBoard(Integer.parseInt(availableSquares.get(square)), "0");
        }
        return currentPlayer() == playerOne ? max : min;
    }
}
