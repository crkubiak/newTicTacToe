public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        Validation validation = new Validation();
        Rules rules = new Rules();
        Game game = new Game(board, validation, rules);
        game.playGame();
    }
}
