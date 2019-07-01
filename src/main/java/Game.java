public class Game {
    private Board board;
    private Rules rules;
    private Validation validation;
    private Player playerOne;
    private Player playerTwo;
    private int turnCount = 0;
    private String[] markers = {"X", "O"};

    public Game(Board board, Rules rules, Validation validation, Player playerOne, Player playerTwo) {
        this.board = board;
        this.rules = rules;
        this.validation = validation;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String currentPlayer() {
        return markers[turnCount % 2];
    }

    public void move(int selectedSquare) {
        if (validation.validate(board, selectedSquare)) {
            System.out.print("\033[H\033[2J");
            board.markBoard(selectedSquare, currentPlayer());
            rules.victoryCheck(board.currentMoves(), currentPlayer());
            turnCount += 1;
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println(selectedSquare + " is an invalid move!");
        }
    }

    void individualGameLoop() {
        while (turnCount < 9 && rules.didPlayerWin().length() == 0) {
            if (turnCount % 2 == 0) {
                move(playerOne.takeTurn(board));
            } else {
                move(playerTwo.takeTurn(board));
            }
        }
        System.out.println(board.displayBoard());
        if (rules.didPlayerWin().length() != 0) {
            System.out.println("Player " + rules.didPlayerWin() + " wins!");
        } else {
            System.out.println("The game is a draw");
        }
    }
}
