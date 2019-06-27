public interface Game {
    String currentPlayer();
    void move(int selectedSquare);
    void individualGameLoop();
}
