import java.util.InputMismatchException;
import java.util.Scanner;

public class Human implements Player {

    private int inputInt(String prompt, Scanner playerTurn) {
        try {
            return playerTurn.nextInt();
        } catch (InputMismatchException e) {
            System.out.print(prompt);
            playerTurn.next();
            return inputInt(prompt, playerTurn);
        }
    }

    public int takeTurn(Board board){
        Scanner playerTurn = new Scanner(System.in);
        System.out.println(board.displayBoard());
        System.out.println("Please enter a number 1-9: ");
        return inputInt("Input was not an integer between 1-9. Please pick again: ", playerTurn);
    }
}
