import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int turnCount = 0;

        Integer[] player1 = {0,0,0,0,0,0,0,0,0};
        Integer[] player2 = {0,0,0,0,0,0,0,0,0};

        Integer[][] victory = {
                {1,2,3}, {4,5,6}, {7,8,9},
                {1,4,7}, {2,5,8}, {3,6,9},
                {1,5,9}, {3,5,7}
        };
        Integer[] boardChoices = {1,2,3,4,5,6,7,8,9};
        String[] displayBoard = {"1","2","3","4","5","6","7","8","9"};

        System.out.print("\033[H\033[2J");

        Scanner startGame = new Scanner(System.in);
        System.out.print("Would you like to play a game? (y/n): ");
        boolean hasY = startGame.hasNext("y");
        String playerWon = "";
        boolean validMove = true;

        while (hasY) {
            System.out.print("\033[H\033[2J");
            String createBoard = String.format("\n\n     %s|%s|%s\n     -+-+-\n     %s|%s|%s\n     -+-+-\n     %s|%s|%s\n\n",
                    displayBoard[0], displayBoard[1], displayBoard[2], displayBoard[3], displayBoard[4], displayBoard[5], displayBoard[6], displayBoard[7], displayBoard[8]);
//            System.out.println("Turn: " + turnCount);
            System.out.println(createBoard);
            if (turnCount == 9 && playerWon == "") {
                System.out.println("The game is a draw");
                hasY = false;
                break;
            }

            if (!validMove) {
                System.out.println("Invalid move!");
                validMove = true;
            }
            if (playerWon != ""){
                hasY = false;
                String winner = playerWon + " has won the game.";
                System.out.println(winner);
                break;
            }
            System.out.println("P1 " + Arrays.toString(player1));
            System.out.println("P2 " + Arrays.toString(player2));
            System.out.println("Display Board: " + Arrays.toString(displayBoard));
            System.out.println("Board Choices: " + Arrays.toString(boardChoices));

            if (turnCount % 2 == 0) {
                Scanner playerOneTurn = new Scanner(System.in);
                System.out.print("Player One (X), Please select a move (1-9): ");
                int playerOneOutput = playerOneTurn.nextInt();
                for (int i = 0; i < boardChoices.length; i++) {
                    if (playerOneOutput == boardChoices[i]) {
                        displayBoard[i] = "X";
                        player1[i] = boardChoices[i];
                        boardChoices[i] = 0;
                        turnCount += 1;
                        break;
                    } else if (playerOneOutput != boardChoices[i] && i == 8) {
                        validMove = false;
                    }
                }
                for (int j = 0; j < 8; j++) {
                    HashSet<Integer> victorySet = new HashSet<>();
                    victorySet.addAll(Arrays.asList(player1));
                    victorySet.retainAll(Arrays.asList(victory[j]));
                    if (victorySet.size() == 3){
                        playerWon = "Player One";
                    }
                }
            } else {
                Scanner playerTwoTurn = new Scanner(System.in);
                System.out.print("Player Two (O), Please select a move (1-9): ");
                int playerTwoOutput = playerTwoTurn.nextInt();
                for (int i = 0; i < boardChoices.length; i++) {
                    if (playerTwoOutput == boardChoices[i]) {
                        displayBoard[i] = "O";
                        player2[i] = boardChoices[i];
                        boardChoices[i] = 0;
                        turnCount += 1;
                        break;
                    } else if (playerTwoOutput != boardChoices[i] && i == 8) {
                        validMove = false;
                    }
                }
                for (int j = 0; j < 8; j++) {
                    HashSet<Integer> victorySet = new HashSet<>();
                    victorySet.addAll(Arrays.asList(player2));
                    victorySet.retainAll(Arrays.asList(victory[j]));
                    if (victorySet.size() == 3){
                        playerWon = "Player Two";
                    }
                }
            }
        }
    }
}
