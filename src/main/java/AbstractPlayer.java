public abstract class AbstractPlayer implements Player {
    private String marker;

    protected AbstractPlayer(String marker) {
        this.marker = marker;
    }

    String getMarker() {
        return this.marker;
    }
}
