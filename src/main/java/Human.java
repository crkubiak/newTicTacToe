import java.util.Scanner;

public class Human implements Player {
    private Validation validation = new Validation();

    public int takeTurn(Board board){
        Scanner playerTurn = new Scanner(System.in);
        System.out.println(board.displayBoard());
        System.out.println("Please enter a number 1-9: ");
        return validation.inputInt("Integers only! Please enter a number 1-9: ", playerTurn);
    }
}
