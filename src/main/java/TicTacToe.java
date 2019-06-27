import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        boolean wantsToPlay = true;
        while (wantsToPlay){
            System.out.print("\033[H\033[2J");
            Board board = new Board();
            Validation validation = new Validation();
            Rules rules = new Rules();
            Games game = new HumVsHumGame(board, validation, rules);
            game.individualGameLoop();
            System.out.println("Would you like to play again? (y/n): ");
            Scanner playAgain = new Scanner(System.in);
            wantsToPlay = playAgain.hasNext("y");
        }
    }
}
