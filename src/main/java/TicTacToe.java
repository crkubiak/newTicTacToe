public class TicTacToe {
    public static void main(String[] args) {
        Validation validation = new Validation();
        Board board = new Board();
        Game game = new Game(board, validation);
        game.playGame();
    }
}
