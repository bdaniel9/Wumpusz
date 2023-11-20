package Tesztek;

import Wumpusz.Hozzaadas.VeremHozzaad;
import Wumpusz.Szerkesztes.Palya;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class VeremHozzaadTest {

    @Before
    public void setUp() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }

    @Test
    public void testVeremHozzaadas() {
        String input = "c3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        VeremHozzaad.veremHozzaad('V');
        assertEquals('V', Palya.palya[3][3]);
    }

    @Test
    public void testErvenytelenPozicio() {
        String input = "invalid\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        VeremHozzaad.veremHozzaad('V');
        assertEquals(' ', Palya.palya[3][3]);
    }
}
