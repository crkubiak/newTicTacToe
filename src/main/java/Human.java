import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends AbstractPlayer {
    public Human() {
        super("X");
    }

    public Human(String marker) {
        super(marker);
    }

    public int takeTurn(Board board){
        Scanner playerTurn = new Scanner(System.in);
        System.out.println(board.displayBoard());
        System.out.println("Please enter a number 1-9: ");
        return inputInt("Integers only! Please enter a number 1-9: ", playerTurn);
    }

    private int inputInt(String prompt, Scanner playerTurn) {
        try {
            return playerTurn.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(prompt);
            playerTurn.next();
            return inputInt(prompt, playerTurn);
        }
    }
}
