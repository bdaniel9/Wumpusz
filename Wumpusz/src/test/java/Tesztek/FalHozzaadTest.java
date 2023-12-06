package Tesztek;

import wumpusz.Hozzaadas.FalHozzaad;
import wumpusz.Szerkesztes.Palya;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class FalHozzaadTest {

    @Before
    public void setUp() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }

    @Test
    public void testFalHozzaadas() {
        String input = "c3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        char fal = 'F';
        FalHozzaad.falHozzaad(fal);
        System.out.println("Sikerült hozzáadni az elemet!");
        assertEquals(fal, Palya.palya[3][3]);
    }

    @Test
    public void testErvenytelenPozicio() {
        String input = "invalid";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        char fal = 'F';
        FalHozzaad.falHozzaad(fal);
        assertEquals(' ', Palya.palya[3][3]);
    }
}
