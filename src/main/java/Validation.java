public class Validation {
    private boolean moveIsInRange(int selectedSquare) {
        return (selectedSquare > 0 && selectedSquare < 10) ;
    }

    private boolean moveIsAvailable(Board board, int selectedSquare) {
        return ((!board.currentMoves()[selectedSquare - 1].equals("X")) && (!board.currentMoves()[selectedSquare - 1].equals("O")));
    }

    public boolean validate(Board board, int playerTurn) {
        return moveIsInRange(playerTurn) && moveIsAvailable(board, playerTurn);
    }
}
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Validation {

//    private void outOfRangeError(int playerTurn) {
//        System.out.println(playerTurn + " is not between 1 - 9. Please pick again.");
//    }
//
//    private void notAvailableError(int playerTurn) {
//        System.out.println(playerTurn + " is not available. Please pick again.");
//    }
//
//    boolean moveIsInRange(Scanner playerTurnScanner) {
//        int playerTurn = playerTurnScanner.nextInt();
//        return (playerTurn > 0 && playerTurn < 10) ;
//    }
//
//    boolean moveIsAvailable(Board board, Scanner playerTurnScanner) {
//        int playerTurn = playerTurnScanner.nextInt();
//        return ((!board.currentMoves()[playerTurn - 1].equals("X")) && (!board.currentMoves()[playerTurn - 1].equals("O")));
//    }
//
//    int inputInt(String prompt, Scanner playerTurnScanner, Board board) {
//        try {
//            if(moveIsInRange(playerTurnScanner) && moveIsAvailable(board, playerTurnScanner)) {
//                return playerTurnScanner.nextInt();
//            } else {
//                return inputInt(prompt, playerTurnScanner, board);
//            }
//        } catch (InputMismatchException e) {
//            System.out.print(prompt);
//            playerTurnScanner.next();
//            return inputInt(prompt, playerTurnScanner, board);
//        }
//    }
//
//    public int validate(String prompt, Scanner playerTurnScanner, Board board) {
//        return inputInt(prompt, playerTurnScanner, board);
//    }
//}
