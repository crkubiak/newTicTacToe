public class RandomComputer implements Player {

    private String marker = "X";

    public String getMarker() {
        return marker;
    }

    public void setMarker(String selectedMarker) {
        marker = selectedMarker;
    }

    public int takeTurn(Board board) {
        return board.availableSpaces().get(0);
    }
}
