import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    public boolean validate(int choice, Board board) {
        boolean validity = moveIsInRange(choice) && moveIsAvailable(choice, board);
        if (!validity) {
            System.out.print("\033[H\033[2J");
            System.out.println(choice + " is an invalid turn!");
        }
        return validity;
    }

    private boolean moveIsInRange(int selectedSquare) {
        return (selectedSquare > 0 && selectedSquare < 10) ;
    }

    private boolean moveIsAvailable(int selectedSquare, Board board) {
        return ((!board.currentMoves()[selectedSquare - 1].equals("X")) &&
                (!board.currentMoves()[selectedSquare - 1].equals("O")));
    }
}
