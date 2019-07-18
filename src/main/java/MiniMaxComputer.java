public class MiniMaxComputer extends AbstractPlayer {

    public MiniMaxComputer() {
        super("O");

    }

    public MiniMaxComputer(String marker) {
        super((marker));

    }

    public int takeTurn(Board board) {
//
        return new MiniMax(board).chooseMove() + 1;
//        return 0;
    }
}

/*
- Computer player should take a turn - MiniMaxComputer.takeTurn(board)
    - Current game board is passed into takeTurn
- Board is then fed into the minimax function MM.score()
- MM will recurse through each level of the board
- After each marked move MM should check for victory
    - If MM is victorious it should be scored + 10
    - If opponent is victorious it should be scored -10
    - Draw is 0

 */