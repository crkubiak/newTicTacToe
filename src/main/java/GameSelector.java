public class GameSelector {
    private Board board = new Board();
    private Validation validation = new Validation();
    private Rules rules = new Rules();
    private Game configuration;

    public Game gameSelection(int gameType) {
        switch (gameType) {
            case 1:
                configuration = new HumVsHumGame(board, validation, rules);
                break;
            case 2:
                RandomComputer randomComputer = new RandomComputer();
                configuration = new HumVsRandCPUGame(board, validation, rules, randomComputer);
                break;
        }
        return configuration;
    }
}
