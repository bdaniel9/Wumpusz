package Tesztek;

import Wumpusz.Hozzaadas.aranyHozzaad;
import Wumpusz.Szerkesztes.Palya;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class AranyHozzaadTest {

    @Before
    public void setUp() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }

    @Test
    public void testAranyHozzaadas() {
        String input = "c3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        aranyHozzaad.aranyHozzadas();
        assertEquals('A', Palya.palya[3][3]);
    }

    @Test
    public void testErvenytelenPozicio() {
        String input = "invalid\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        aranyHozzaad.aranyHozzadas();
        assertEquals(' ', Palya.palya[3][3]);
    }
}