import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void testGetMarker() {
        Human human = new Human();
        String expectedMarker = "X";
        String actualMarker = human.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    public void testSetMarker() {
        Human human = new Human();
        String expectedMarker = "O";
        human.setMarker("O");
        String actualMarker = human.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }
}