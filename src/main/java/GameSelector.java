class GameSelector {
    private Board board = new Board();
    private Validation validation = new Validation();
    private Rules rules = new Rules();
    private MiniMax2 mm = new MiniMax2(board);
    private AbstractPlayer playerOne;
    private AbstractPlayer playerTwo;

    Game gameSelection(int gameType) {
        switch (gameType) {
            case 1:
                playerOne = new Human();
                playerTwo = new Human("O");
                break;
            case 2:
                playerOne = new Human();
                playerTwo = new RandomComputer();
                break;
            case 3:
                playerOne = new MiniMaxComputer(mm,"X");
                playerTwo = new Human("O");
                break;
            case 4:
                playerOne = new RandomComputer("X");
                playerTwo = new RandomComputer();
                break;
        }
        return new Game(board, rules, validation, playerOne, playerTwo);
    }
}