import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    public boolean validate(int choice, Board board) {
        return moveIsInRange(choice) && moveIsAvailable(choice, board);
    }

    private boolean moveIsInRange(int selectedSquare) {
        return (selectedSquare > 0 && selectedSquare < 10) ;
    }

    private boolean moveIsAvailable(int selectedSquare, Board board) {
        return ((!board.currentMoves()[selectedSquare - 1].equals("X")) &&
                (!board.currentMoves()[selectedSquare - 1].equals("O")));
    }
}
