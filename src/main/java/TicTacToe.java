public class TicTacToe {
    public static void main(String[] args) {
        IO io = new IO();
        Validation validation = new Validation();
        Board board = new Board();
        Game game = new Game(board, validation, io);
        game.playGame();
    }
}
