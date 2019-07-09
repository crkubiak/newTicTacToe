import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Node {
    private int square;
    private int score;
    private List<Node> children;
    private boolean isMaxPlayer;

    public Node(int square, boolean isMaxPlayer) {
        this.square = square;
        this.isMaxPlayer = isMaxPlayer;
        children = new ArrayList<>();
    }

    int getSquare() {
        return square;
    }

    boolean isMaxPlayer() {
        return isMaxPlayer;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

    List<Node> getChildren() {
        return children;
    }

    void addChild(Node newNode) {
        children.add(newNode);
    }


//    private Optional<Integer> score;
//    private ArrayList<Node> children = new ArrayList<Node>();
//    public Node(Integer score) {
//        this.score = Optional.of(score);
//    }
//
//    public Node() {
//        this.score = Optional.empty();
//    }
//
//    Optional<Integer> score() {
//        return score;
//    }
//
//    public ArrayList<Node> children() {
//        return children;
//    }
//
//    public void addChild(Node child) {
//        children.add(child);
//    }
}
