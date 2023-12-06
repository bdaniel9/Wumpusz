package Tesztek;

import wumpusz.Szerkesztes.Palya;
import org.junit.Test;

public class PalyaTest {

    @Test
    public void testValidN() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }
}
