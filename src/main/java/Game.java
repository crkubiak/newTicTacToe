import java.util.Scanner;

public class Game {

    private Board board;
    private Validation validation;
    private int turnCount = 0;
    private String[] markers = {"X","O"};
    private Scanner playerTurn;
    private boolean gameWon = false;
    private int[][] winningBoards = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };

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

    public void victory() {

//        String[][] winningBoards = {
//                {"1","2","3"},
//                {"4","5","6"},
//                {"7","8","9"},
//                {"1","4","7"},
//                {"2","5","8"},
//                {"3","6","9"},
//                {"1","5","9"},
//                {"3","5","7"}
//        };
    }

    public void playGame() {
        playerTurn = new Scanner(System.in);
        while(turnCount < 9) {
            System.out.print("\033[H\033[2J");
            System.out.println(board.displayBoard());
            System.out.println("Please enter a number 1-9: ");
            int playerInput = validation.inputInt("Integers only! Please enter a number 1-9: ", playerTurn);
            move(playerInput);

        }
    }
}
