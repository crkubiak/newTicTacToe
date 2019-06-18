import java.util.Scanner;

public class Game {

    private Board board;
    private Validation validation;
    private Rules rules;
    private int turnCount = 0;
    private String[] markers = {"X","O"};

    public Game(Board board, Validation validation, Rules rules) {
        this.board = board;
        this.validation = validation;
        this.rules = rules;

    }

    public String currentPlayer() {
        return markers[turnCount % 2];
    }

    public void move(int selectedSquare) {
        if(this.validation.moveIsInRange(selectedSquare)
                && this.validation.moveIsAvailable(selectedSquare, this.board)){
            this.board.move(selectedSquare, this.currentPlayer());
            this.rules.victoryCheck(board.currentBoard, currentPlayer());
            this.turnCount += 1;
        } else {
            System.out.println("Invalid Move!");
        }
    }

    void playGame() {
        Scanner playerTurn = new Scanner(System.in);
        while(turnCount < 9) {
//            System.out.print("\033[H\033[2J");
            System.out.println(board.displayBoard());
            System.out.println("Please enter a number 1-9: ");
            int playerInput = validation.inputInt("Integers only! Please enter a number 1-9: ", playerTurn);
            move(playerInput);
        }
    }
}
