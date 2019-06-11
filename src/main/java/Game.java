import java.util.Scanner;

public class Game {

    private Board board;
    private Validation validation;
    private int turnCount = 0;
    private String[] markers = {"X","O"};
    private Scanner playerTurn;

    public Game(Board board, Validation validation) {
        this.board = board;
        this.validation = validation;
    }

    public String currentPlayer() {
        return markers[turnCount % 2];
    }

    public void move(int selectedSquare) {
        if(this.validation.moveIsInRange(selectedSquare)
                && this.validation.moveIsAvailable(selectedSquare, this.board)){
            this.board.move(selectedSquare, this.currentPlayer());
            this.turnCount += 1;
        } else {
            System.out.println("Invalid Move!");
        }
    }

    public void playGame() {
        playerTurn = new Scanner(System.in);
        System.out.println(board.displayBoard() + " " + turnCount);
        while(turnCount < 9) {
            int playerInput = validation.inputInt("Please enter a number 1-9: ", playerTurn);
            move(playerInput);
            System.out.println(board.displayBoard() + " " + turnCount);
        }
    }
}
