package Tesztek;

import Wumpusz.Hozzaadas.hosHozzaad;
import Wumpusz.Szerkesztes.Palya;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class HosHozzaadTest {

    @Before
    public void setUp() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }

    @Test
    public void testHosHozzaadas() {
        String input = "c3\n"; // Példa bemenet
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        hosHozzaad.hosHozzadas();
        assertEquals('H', Palya.palya[3][3]);
    }

    @Test
    public void testErvenytelenPozicio() {
        String input = "invalid\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        hosHozzaad.hosHozzadas();
        assertEquals(' ', Palya.palya[3][3]);
    }

}
