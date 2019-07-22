import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        boolean wantsToPlay = true;
        while (wantsToPlay){
            System.out.print("\033[H\033[2J");
            System.out.println("Game Types:\n" +
                    "1. Human vs. Human\n" +
                    "2. Human vs Random Choice CPU\n" +
                    "3. Human vs MiniMax Computer\n" +
                    "4. Random Choice CPU vs Random Choice CPU\n" +
                    "5. MiniMaxComputer vs. MiniMax Computer\n" +
                    "\nWhat type of game would you like to play: ");
            Scanner pickAGame = new Scanner(System.in);
            int gameType = pickAGame.nextInt();
            GameSelector gameSelector = new GameSelector();
            Game game = gameSelector.gameSelection(gameType);
            game.individualGameLoop();
            System.out.println("Would you like to play again? (y/n): ");
            Scanner playAgain = new Scanner(System.in);
            wantsToPlay = playAgain.hasNext("y");
        }
    }
}
