public class Board {
    private String[] boardMarks = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public String[] currentMoves() {
        return this.boardMarks;
    }

    public void move(int selectedSquare, String playerMarker) {
        this.boardMarks[selectedSquare - 1] = playerMarker;
    }
}
