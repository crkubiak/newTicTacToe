class GameSelector {
    private Board board = new Board();
    private Validation validation = new Validation();
    private Rules rules = new Rules();
    private Player playerOne;
    private Player playerTwo;

    Game gameSelection(int gameType) {
        switch (gameType) {
            case 1:
                playerOne = new Human();
                playerTwo = new Human();
                break;
            case 2:
                playerOne = new Human();
                playerTwo = new RandomComputer();
                break;
            case 3:
                playerOne = new RandomComputer();
                playerTwo = new RandomComputer();
        }
        return new Game(board, rules, validation, playerOne, playerTwo);
    }
}