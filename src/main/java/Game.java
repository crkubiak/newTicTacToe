class Game {
    private Board board;
    private Validation validation;
    private Rules rules;
    private AbstractPlayer playerOne;
    private AbstractPlayer playerTwo;
    private int turnCount = 0;

    Game(Board board, Validation validation, Rules rules, AbstractPlayer playerOne, AbstractPlayer playerTwo) {
        this.board = board;
        this.validation = validation;
        this.rules = rules;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    AbstractPlayer currentPlayer() {
        return (turnCount % 2 == 0) ? this.playerOne : this.playerTwo;
    }

    void turn(int selectedSquare) {
        if (validation.validate(selectedSquare, board)) {
            System.out.print("\033[H\033[2J");
            board.move(selectedSquare, currentPlayer().getMarker());
            rules.victoryCheck(board.currentMoves(), currentPlayer().getMarker());
            turnCount += 1;
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println(selectedSquare + " is an invalid turn!");
        }
    }

    void loop() {
        while (turnCount < 9 && rules.didPlayerWin().length() == 0) {
                turn(currentPlayer().takeTurn(board));
        }
        System.out.println(board.displayBoard());
        if (rules.didPlayerWin().length() != 0) {
            System.out.println("Player " + rules.didPlayerWin() + " wins!");
        } else {
            System.out.println("The game is a draw");
        }
    }
}
