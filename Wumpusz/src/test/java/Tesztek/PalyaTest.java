package Tesztek;

import Wumpusz.Szerkesztes.Palya;
import org.junit.Assert;
import org.junit.Test;

public class PalyaTest {

    @Test
    public void testValidN() {
        Palya.N = 10;
        Palya.palyaInicializalasa();
    }
}
