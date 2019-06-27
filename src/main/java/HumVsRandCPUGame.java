public class HumVsRandCPUGame implements Games {
    private Board board;
    private Validation validation;
    private Rules rules;
    private int turnCount = 0;
    private String[] markers = {"X", "O"};

    public HumVsRandCPUGame(Board board, Validation validation, Rules rules) {
        this.board = board;
        this.validation = validation;
        this.rules = rules;
    }

    public String currentPlayer() {
        return markers[turnCount % 2];
    }

    public void move(int selectedSquare) {

    }

    public void individualGameLoop() {

    }
}
