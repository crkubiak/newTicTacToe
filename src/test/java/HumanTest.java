import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void testTakeTurn() {
        Player player = new Human();
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        int expectedInt = 8;
        int actualInt = player.takeTurn(testBoard);
        assertEquals(expectedInt, actualInt);
    }
}
