import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

    public boolean moveIsInRange(int selectedSquare) {
        return (selectedSquare > 0 && selectedSquare < 10) ;
    }

    public boolean moveIsAvailable(int selectedSquare, Board board) {
        return ((board.currentMoves()[selectedSquare - 1] != "X") && (board.currentMoves()[selectedSquare - 1] != "O"));
    }

    public int inputInt(String prompt, Scanner playerTurn) {
        try {
            return playerTurn.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(prompt);
            playerTurn.next();
            return inputInt(prompt, playerTurn);
        }
    }
}
