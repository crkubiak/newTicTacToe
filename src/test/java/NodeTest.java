import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void createsANodeWithNoValueAndNoChildren() {
        Node node = new Node();

        boolean expectedHasValue = false;
        boolean actualHasValue = node.hasValue();

        assertEquals(expectedHasValue, actualHasValue);
    }

    @Test
    public void createsANodeWithNoChildren() {
        Node node = new Node();

        boolean expectedHasChildren = true;
        boolean actualHasChildren = node.children().isEmpty();

        assertEquals(expectedHasChildren, actualHasChildren);
    }

    @Test
    public void createsANodeWithAValue() {
        Node node = new Node(5);

        boolean expectedHasValue = true;
        boolean actualHasValue = node.hasValue();

        int expectedValue = 5;
        int actualValue = node.value();

        assertEquals(expectedHasValue, actualHasValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void createsANodeWithOneChildAndAValue() {
        Node child = new Node(10);
        ArrayList<Node> children = new ArrayList<>();
        children.add(child);
        Node parent = new Node(40, children);

        boolean expectChild = true;
        boolean actualChild = parent.children().contains(child);

        assertEquals(expectChild, actualChild);
    }

    @Test
    public void createsANodeWithOneChildAndNoValue() {
        Node child = new Node(20);
        ArrayList<Node> children = new ArrayList<>();
        children.add(child);
        Node parent = new Node(children);

        boolean expectedChild = true;
        boolean actualChild = parent.children().contains(child);

        assertEquals(expectedChild, actualChild);
    }

    @Test
    public void createsANodeWithThreeChildrenAndValue() {
        Node child1 = new Node(20);
        Node child2 = new Node(30);
        Node child3 = new Node(40);
        ArrayList<Node> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Node parent = new Node(40, children);

        ArrayList<Node> expectedChildren = children;
        ArrayList<Node> actualChildren = parent.children();

        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    public void createsALinkedList() {
        Node child = new Node(10);
        ArrayList<Node> childToParent = new ArrayList<>();
        childToParent.add(child);
        Node parent = new Node(20, childToParent);
        ArrayList<Node> parentToGrandParent = new ArrayList<>();
        parentToGrandParent.add(parent);
        Node grandParent = new Node(30, parentToGrandParent);

        ArrayList<Node> expectedLink1 = childToParent;
        ArrayList<Node> actualLink1 = parent.children();
        ArrayList<Node> expectedLink2 = parentToGrandParent;
        ArrayList<Node> actualLink2 = grandParent.children();

        assertEquals(expectedLink1, actualLink1);
        assertEquals(expectedLink2, actualLink2);
    }
}