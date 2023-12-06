package Tesztek;

import wumpusz.Hozzaadas.WumpuszHozzaad;
import wumpusz.Szerkesztes.Palya;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static wumpusz.Szerkesztes.Palya.palya;
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
        WumpuszHozzaad.wumpuszHozzaad();
        assertEquals('W', palya[3][3]);
    }

    @Test
    public void testErvenytelenPozicio() {
        String input = "invalid\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WumpuszHozzaad.wumpuszHozzaad();
        assertEquals(' ', palya[3][3]);
    }
}
