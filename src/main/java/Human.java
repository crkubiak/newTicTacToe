public class Human implements Player {
    private String marker = "X";

    public String getMarker() {
        return marker;
    }

    public void setMarker(String selectedMarker) {
        marker = selectedMarker;
    }
}