import org.junit.Test;

import static org.junit.Assert.*;

public class IOTest {
    @Test
    public void testInvalidMessageIO() {
        IO testIO = new IO();
        String expectedIO = "Invalid move!";
        String actualIO = testIO.invalidMoveIO();
        assertEquals(expectedIO, actualIO);
    }

    @Test
    public void testSelectAMoveIO() {
        IO testIO = new IO();
        String expectedIO = "Please select a number between 1 - 9: ";
        String actualIO = testIO.selectAMoveIO();
        assertEquals(expectedIO, actualIO);
    }
}