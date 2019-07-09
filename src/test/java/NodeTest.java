import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void aNodeHasADefaultScoreOfZero() {
        Node node = new Node(3, true);

        Optional<Integer> expectedResult = Optional.empty();
        Optional<Integer> actualResult = node.score();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void aNodeCanHaveAScoreOtherThanZero() {
        Node node = new Node(100);

        Optional<Integer> expectedResult = Optional.of(100);
        Optional<Integer> actualResult = node.score();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void aNodeStartsOffWithNoChildren() {
        Node node = new Node();

        ArrayList<Node> expectedArrayList = new ArrayList<Node>();
        ArrayList<Node> actualArrayList = node.children();

        assertEquals(expectedArrayList, actualArrayList);
    }

    @Test
    public void addOneChildToANode() {
        Node parent = new Node();
        Node child = new Node(15);
        parent.addChild(child);

        ArrayList<Node> expectedChildren = new ArrayList<Node>();
        expectedChildren.add(child);
        ArrayList<Node> actualChildren = parent.children();

        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    public void addTwoChildrenToANode() {
        Node parent = new Node();
        Node child1 = new Node(15);
        Node child2 = new Node(15);
        parent.addChild(child1);
        parent.addChild(child2);

        ArrayList<Node> expectedChildren = new ArrayList<Node>();
        expectedChildren.add(child1);
        expectedChildren.add(child2);
        ArrayList<Node> actualChildren = parent.children();

        assertEquals(expectedChildren, actualChildren);
    }

}