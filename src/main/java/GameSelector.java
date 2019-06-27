public class GameSelector {

    private Games game;

    public Object gameSelection(int gameType) {
        switch (gameType) {
            case 1:
                Board board = new Board();
                Validation validation = new Validation();
                Rules rules = new Rules();
                Games game = new HumVsHumGame(board, validation, rules);
                game.individualGameLoop();
                break;
//            case 2:
//                Board board = new Board();
//                Validation validation = new Validation();
//                Rules rules = new Rules();
//                Games game = new HumVsRandCPUGame(board, validation, rules);
//                game.individualGameLoop();
//                break;
        }


        return game;
    }
}
