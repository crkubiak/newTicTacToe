import java.util.ArrayList;

public class Board {
    private String[] newBoard = {"1","2","3","4","5","6","7","8","9"};
    String[] currentBoard;

    Board(String[] currentBoard) {
        this.currentBoard = currentBoard;
    }

    Board() {
        this.currentBoard = newBoard;
    }

    public String[] currentMoves() {
        return currentBoard;
    }

    public String displayBoard() {
        return String.format("%s|%s|%s\n-+-+-\n%s|%s|%s\n-+-+-\n%s|%s|%s",
                currentBoard[0], currentBoard[1], currentBoard[2],
                currentBoard[3], currentBoard[4], currentBoard[5],
                currentBoard[6], currentBoard[7], currentBoard[8]);
    }

    public void move(int selectedSquare, String playerMarker) {
        currentBoard[selectedSquare - 1] = playerMarker;
    }

    public ArrayList<Integer> availableSpaces() {
        ArrayList<Integer> available = new ArrayList<>();
        for (int space = 0; space < currentBoard.length; space++) {
            if (!currentBoard[space].equals("X") && !currentBoard[space].equals("O")) {
                available.add(space);
            }
        }
        return available;
    }
}
