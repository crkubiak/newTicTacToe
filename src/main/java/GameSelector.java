enum GameType {
    HUMAN_VS_HUMAN,
    HUMAN_VS_RANDOM_COMPUTER,
    HUMAN_VS_MINIMAX_COMPUTER,
    RANDOM_COMPUTER_VS_RANDOM_COMPUTER,
    MINIMAX_COMPUTER_VS_MINIMAX_COMPUTER;
}

class GameSelector {
    private Board board = new Board();
    private Validation validation = new Validation();
    private Rules rules = new Rules();
    private AbstractPlayer playerOne;
    private AbstractPlayer playerTwo;

    Game gameSelection(int gameType) {
        switch (GameType.values()[gameType - 1]) {
            case HUMAN_VS_HUMAN:
                playerOne = new Human();
                playerTwo = new Human("O");
                break;
            case HUMAN_VS_RANDOM_COMPUTER:
                playerOne = new Human();
                playerTwo = new RandomComputer();
                break;
            case HUMAN_VS_MINIMAX_COMPUTER:
                playerOne = new Human();
                playerTwo = new MiniMaxComputer();
                break;
            case RANDOM_COMPUTER_VS_RANDOM_COMPUTER:
                playerOne = new RandomComputer("X");
                playerTwo = new RandomComputer();
                break;
            case MINIMAX_COMPUTER_VS_MINIMAX_COMPUTER:
                playerOne = new MiniMaxComputer("X");
                playerTwo = new MiniMaxComputer();
                 break;
        }
        return new Game(board, rules, validation, playerOne, playerTwo);
    }
}