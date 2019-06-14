public class Board {

    protected String[] currentBoard = {"1","2","3","4","5","6","7","8","9"};

    public String[] currentMoves() {
        return this.currentBoard;
    }

    public String displayBoard() {
        return String.format("%s|%s|%s\n-+-+-\n%s|%s|%s\n-+-+-\n%s|%s|%s",
                currentBoard[0], currentBoard[1], currentBoard[2],
                currentBoard[3], currentBoard[4], currentBoard[5],
                currentBoard[6], currentBoard[7], currentBoard[8]);
    }

    public void move(int selectedSquare, String playerMarker) {
        this.currentBoard[selectedSquare - 1] = playerMarker;
    }
}
