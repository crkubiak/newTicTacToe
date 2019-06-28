public class GameSelector {
    private Board board = new Board();
    private Validation validation = new Validation();
    private Rules rules = new Rules();

    public void gameSelection(int gameType) {
        switch (gameType) {
            case 1:
                Game gameHVH = new HumVsHumGame(board, validation, rules);
                gameHVH.individualGameLoop();
                break;
            case 2:
                RandomComputer randomComputer = new RandomComputer();
                Game gameHVRc = new HumVsRandCPUGame(board, validation, rules, randomComputer);
                gameHVRc.individualGameLoop();
                break;
        }
    }
}
