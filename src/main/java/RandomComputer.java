public class RandomComputer implements Player {
    public int takeTurn(Board board) {
        java.util.Random random = new java.util.Random();
        int randomSquare = random.nextInt(board.availableSpaces().size());
        return board.availableSpaces().get(randomSquare) + 1;
    }
}
