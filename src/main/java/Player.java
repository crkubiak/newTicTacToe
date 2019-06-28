public interface Player {
    String getMarker();
    void setMarker(String selectedMarker);
    int takeTurn(Board board);
}
