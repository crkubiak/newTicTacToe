import org.junit.Test;

import static org.junit.Assert.*;

public class RandomComputerTest {
    @Test
    public void testGetMarker() {
        RandomComputer rc = new RandomComputer();
        String expectedMarker = "X";
        String actualMarker = rc.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    public void testSetMarker() {
        RandomComputer rc = new RandomComputer();
        String expectedMarker = "O";
        rc.setMarker("O");
        String actualMarker = rc.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }
}