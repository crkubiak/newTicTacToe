public class MiniMaxComputer extends AbstractPlayer {
    MiniMax2 mm;
    public MiniMaxComputer(MiniMax2 mm) {
        super("O");
        this.mm = mm;
    }

    public MiniMaxComputer(MiniMax2 mm, String marker) {
        super((marker));
        this.mm = mm;
    }

    public int takeTurn(Board board) {

        mm.score(0, board);
        return mm.miniMaxMove;
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