public class Game {
    private Board board;
    private Rules rules;
    private Validation validation;
    private AbstractPlayer playerOne;
    private AbstractPlayer playerTwo;
    private int turnCount = 0;
    private String winningMarker;

    public Game(Board board, Rules rules, Validation validation, AbstractPlayer playerOne, AbstractPlayer playerTwo) {
        this.board = board;
        this.rules = rules;
        this.validation = validation;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    AbstractPlayer currentPlayer() {
        return (turnCount % 2 == 0) ? this.playerOne : this.playerTwo;
    }

    void move(int selectedSquare) {
        if (validation.validate(board, selectedSquare)) {
            System.out.print("\033[H\033[2J");
            board.markBoard(selectedSquare, currentPlayer().getMarker());
            rules.victoryCheck(board.currentMoves(), currentPlayer().getMarker());
            winningMarker = currentPlayer().getMarker();
            turnCount += 1;
        } else {
            move(currentPlayer().takeTurn(board));
        }
    }

    void individualGameLoop() {
        while (turnCount < 9 && !rules.didPlayerWin()) {
                move(currentPlayer().takeTurn(board));
        }
        System.out.println(board.displayBoard());
        if (rules.didPlayerWin()) {
            System.out.println("Player " + winningMarker + " wins!");
        } else {
            System.out.println("The game is a draw");
        }
    }
}
