import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class MiniMaxTest {
    @Test
    public void miniMaxReturnsScoreofANodeWithNoChild() {
        Node node = new Node(5);
        MiniMax mm = new MiniMax();

        int expectedScore = 5;
        int actualScore = mm.score(node);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void miniMaxReturnsScoreOfANodeWithOneChild() {
        Node child = new Node(10);
        ArrayList<Node> childToParent = new ArrayList<>();
        childToParent.add(child);
        Node parent = new Node(childToParent);
        MiniMax mm = new MiniMax();

        int expectedScore = 10;
        int actualScore = mm.score(parent);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void miniMaxReturnsScoreOfLinkedList() {
        Node child = new Node(21);
        ArrayList<Node> childToParent = new ArrayList<>();
        childToParent.add(child);
        Node parent = new Node(childToParent);
        ArrayList<Node> parentToGrandParent = new ArrayList<>();
        parentToGrandParent.add(parent);
        Node grandParent = new Node(parentToGrandParent);
        MiniMax mm = new MiniMax();

        int expectedScore = 21;
        int actualScore = mm.score(grandParent);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void miniMaxReturnsLargestOfTwoChildren() {
        Node child1 = new Node(12);
        Node child2 = new Node(27);
        ArrayList<Node> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        Node parent = new Node(children);
        MiniMax mm = new MiniMax();

        int expectedScore = 27;
        int actualScore = mm.score(parent);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void miniMaxReturnsSmallestGrandChild() {
        Node child1 = new Node(-12);
        Node child2 = new Node(402);
        ArrayList<Node> childToParent = new ArrayList<>();
        childToParent.add(child1);
        childToParent.add(child2);
        Node parent = new Node(childToParent);
        ArrayList<Node> parentToGrandParent = new ArrayList<>();
        parentToGrandParent.add(parent);
        Node grandParent = new Node(parentToGrandParent);
        MiniMax mm = new MiniMax();

        int expectedValue = -12;
        int actualValue = mm.score(grandParent);

        assertEquals(expectedValue, actualValue);
    }
}