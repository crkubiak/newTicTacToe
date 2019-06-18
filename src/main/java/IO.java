public class IO {


    public void getMove(String marker) {
        send(marker + " it is your turn to move. Enter a selection.");
    }

    public void alertInvalidMove() {
        send("Invalid Move!");
    }

    public void displayBoard(Board board) {
        send(board.displayBoard());
    }

    private void send(String msg) {
        System.out.println(msg);
    }
}
