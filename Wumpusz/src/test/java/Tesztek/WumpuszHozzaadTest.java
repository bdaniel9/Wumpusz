package Tesztek;

import Wumpusz.Hozzaadas.wumpuszHozzaad;
import Wumpusz.Szerkesztes.Palya;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class WumpuszHozzaadTest {

    @Before
    public void setUp() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }

    @Test
    public void testWumpuszHozzaadas() {
        String input = "c3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        wumpuszHozzaad.wumpuszHozzaad();
        assertEquals('W', Palya.palya[3][3]);
    }

    @Test
    public void testErvenytelenPozicio() {
        String input = "invalid\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        wumpuszHozzaad.wumpuszHozzaad();
        assertEquals(' ', Palya.palya[3][3]);
    }
}
