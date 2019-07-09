public class MiniMaxComputer extends AbstractPlayer {
    public MiniMaxComputer() {
        super("O");
    }

    public MiniMaxComputer(String marker) {
        super((marker));
    }

    public int takeTurn(Board board) {
        return 9;
    }
}
