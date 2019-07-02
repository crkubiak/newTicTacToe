
import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.InputStream;
        import java.io.PrintStream;

        import static org.junit.Assert.*;

public class HumanTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(int data) {
        testIn = new ByteArrayInputStream(new byte[]{(byte) data});
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testTakeTurnReturnsValidPlayerInput() {
        Player player = new Human();
        String[] testBoard = {"X", "X", "X", "O", "O", "X", "X", "O", "9"};
        Board board = new Board(testBoard);
        int expectedInt = 9;
        provideInput('9');
        int actualInt = player.takeTurn(board);
        assertEquals(expectedInt, actualInt);
    }
}