import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Node {
    ArrayList<Node> children;
    boolean hasValue;
    int value;

    public Node(int value, ArrayList<Node> children) {
        this.value = value;
        hasValue = true;
        this.children = children;
    }

    public Node(ArrayList<Node> children) {
        this.value = 0;
        hasValue = false;
        this.children = children;
    }

    public Node(int value) {
        this.value = value;
        hasValue = true;
        children = new ArrayList<>();
    }

    public Node() {
        this.value = 0;
        hasValue = false;
        children = new ArrayList<>();
    }

    public boolean hasValue() {
        return hasValue;
    }

    public ArrayList<Node> children() {
        return children;
    }

    public int value() {
        return value;
    }
}
