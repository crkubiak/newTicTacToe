public class GameSelector {
    public void gameSelection(int gameType) {
        switch (gameType) {
            case 1:
                Board boardHVH = new Board();
                Validation validationHVH = new Validation();
                Rules rulesHVH = new Rules();
                Game gameHVH = new HumVsHumGame(boardHVH, validationHVH, rulesHVH);
                gameHVH.individualGameLoop();
                break;
            case 2:
                Board boardHVRc = new Board();
                Validation validationHVRc = new Validation();
                Rules rulesHVRc = new Rules();
                RandomComputer randomComputerHVRc = new RandomComputer();
                Game gameHVRc = new HumVsRandCPUGame(boardHVRc, validationHVRc, rulesHVRc, randomComputerHVRc);
                gameHVRc.individualGameLoop();
                break;
        }
    }
}
