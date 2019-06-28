public class RandomComputer implements Player {
    private String marker = "X";

    public String getMarker() {
        return marker;
    }

    public void setMarker(String selectedMarker) {
        marker = selectedMarker;
    }

    public int takeTurn(Board board) {
        java.util.Random random = new java.util.Random();
        int randomSquare = random.nextInt(board.availableSpaces().size());
        int returnValue = board.availableSpaces().get(randomSquare);
        return returnValue;
    }
}
