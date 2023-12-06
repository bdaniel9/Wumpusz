package Tesztek;
import wumpusz.Main;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {
    @Test
    public void testMainMethod() {
            String input = "Teszt\n5\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            assertDoesNotThrow(() -> Main.main(new String[]{}));
            System.setIn(System.in);
    }
}
