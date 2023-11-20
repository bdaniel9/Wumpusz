package Tesztek;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import Wumpusz.Alapmenu.AlapMenu;
import Wumpusz.Jatek.Jatek;
import Wumpusz.Szerkesztes.Palyaszerkeszto;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AlapMenuTest {
    @Test
    public void testWelcomeMessageAndUsernameInput() {
        Palyaszerkeszto mockPalyaszerkeszto = mock(Palyaszerkeszto.class);
        Jatek mockJatek = mock(Jatek.class);

        AlapMenu alapMenu = new AlapMenu();
        alapMenu.setPalyaszerkeszto(mockPalyaszerkeszto);
        alapMenu.setJatek(mockJatek);

        String inputUsername = "TesztFelhasznalo\n";
        InputStream in = new ByteArrayInputStream(inputUsername.getBytes());
        System.setIn(in);
    }
}