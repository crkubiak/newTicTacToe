import java.util.Scanner;

public class HumVsRandCPUGame implements Game {
    private Board board;
    private Validation validation;
    private Rules rules;
    private RandomComputer randomComputer;
    private int turnCount = 0;
    private String[] markers = {"X", "O"};

    public HumVsRandCPUGame(Board board, Validation validation, Rules rules, RandomComputer randomComputer) {
        this.board = board;
        this.validation = validation;
        this.rules = rules;
        this.randomComputer = randomComputer;
    }

    public String currentPlayer() {
        return markers[turnCount % 2];
    }

    public void move(int selectedSquare) {
        if (validation.moveIsInRange(selectedSquare)
                && validation.moveIsAvailable(selectedSquare, board)) {
            System.out.print("\033[H\033[2J");
            board.move(selectedSquare, currentPlayer());
            rules.victoryCheck(board.currentMoves(), currentPlayer());
            turnCount += 1;
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println(selectedSquare + " is an invalid move!");
        }
    }

    public void individualGameLoop() {
        Scanner playerTurn = new Scanner(System.in);
        while (turnCount < 9 && rules.didPlayerWin().length() == 0) {
            if (turnCount % 2 == 0) {
                System.out.println(board.displayBoard());
                System.out.println("Please enter a number 1-9: ");
                int playerInput = validation.inputInt("Integers only! Please enter a number 1-9: ", playerTurn);
                move(playerInput);
            } else {
                move(randomComputer.takeTurn(board) + 1);
            }
        }
        System.out.println(board.displayBoard());
        if (rules.didPlayerWin().length() != 0) {
            System.out.println("Player " + rules.didPlayerWin() + " wins!");
        } else {
            System.out.println("The game is a draw");
        }
    }
}
