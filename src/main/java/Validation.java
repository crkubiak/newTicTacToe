public class Validation {
    public boolean validate(Board board, int playerTurn) {
        boolean validMove = moveIsInRange(playerTurn) && moveIsAvailable(board, playerTurn);
        if (!validMove) {
            System.out.print("\033[H\033[2J");
            System.out.println(playerTurn + " is an invalid move!");
        }
        return validMove;
    }

    private boolean moveIsInRange(int selectedSquare) {
        return (selectedSquare > 0 && selectedSquare < 10) ;
    }

    private boolean moveIsAvailable(Board board, int selectedSquare) {
        return ((!board.currentMoves()[selectedSquare - 1].equals("X")) && (!board.currentMoves()[selectedSquare - 1].equals("O")));
    }
}