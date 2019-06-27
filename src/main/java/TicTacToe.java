import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        boolean wantsToPlay = true;
        while (wantsToPlay){
            System.out.print("\033[H\033[2J");
//            Board board = new Board();
//            Validation validation = new Validation();
//            Rules rules = new Rules();
//            Game game = new HumVsHumGame(board, validation, rules);
            System.out.println("Game Types:\n1. Human vs. Human\n2. Human vs Random Choice CPU\n\nWhat type of game would you like to play: ");
            Scanner pickAGame = new Scanner(System.in);
            int gameType = pickAGame.nextInt();
            GameSelector gameSelector = new GameSelector();
            gameSelector.gameSelection(gameType);
//            game.individualGameLoop();
            System.out.println("Would you like to play again? (y/n): ");
            Scanner playAgain = new Scanner(System.in);
            wantsToPlay = playAgain.hasNext("y");
        }
    }
}
