package Wumpusz.Jatek;
import Wumpusz.Alapmenu.AlapMenu;
import Wumpusz.Hozzaadas.hosHozzaad;
import Wumpusz.Hozzaadas.wumpuszHozzaad;
import Wumpusz.Szerkesztes.Palya;
import java.util.Scanner;

import static Wumpusz.Szerkesztes.Palya.palya;

public class Jatek {
    private static boolean felad = false;
    private String irany = "egyenes"; // Alapértelmezett irány: egyenes
    private int hosX;
    private int hosY;
    private int nyilakSzama;
    public static int lepesMennyiseg;

    public Jatek() {
        hosHozzaad hos = new hosHozzaad();
        hosX = hos.getHosPozX();
        hosY = hos.getHosPozY();
        nyilakSzama = wumpuszHozzaad.nyilakSzama;
    }

    public void palyaKiiratas() {
        for (int i = 0; i < Palya.N; i++) {
            for (int j = 0; j < Palya.N; j++) {
                if (i == hosY && j == hosX) {
                    System.out.print("H "); // Hős pozíciója
                } else {
                    System.out.print(palya[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void inditas() {
        Scanner scanner = new Scanner(System.in);

        while (!felad) {
            palyaKiiratas();
            System.out.println("Hős iránya: " + irany);
            System.out.println("Nyilaid száma: " + nyilakSzama);
            System.out.println("Melyik irányba szeretnél menni? (balra, jobbra, mozgas, fel, le, felad, lő):");
            String parancs = scanner.nextLine();

            if (parancs.equals("felad")) {
                System.out.println("Feladtad a játékot. Összesen " + lepesMennyiseg + " lépést tettél meg.");
                felad = true;
                continue;
            }

            if (parancs.equals("mozgas")) {
                int ujX = hosX;
                int ujY = hosY;

                switch (irany) {
                    case "balra" -> ujX--;
                    case "jobbra" -> ujX++;
                    case "fel" -> ujY--;
                    case "le" -> ujY++;
                    default -> {
                        System.out.println("Nem érvényes irány.");
                        continue;
                    }
                }

                if (ujX < 0 || ujX >= Palya.N || ujY < 0 || ujY >= Palya.N || palya[ujY][ujX] == 'F') {
                    System.out.println("Falba ütköztél. Válassz másik irányt.");
                    continue;
                }

                if (palya[ujY][ujX] == 'W') {
                    System.out.println("Meghaltál, mert rá léptél egy Wumpuszra.");
                    felad = true;
                    returnToMainMenu();
                    continue;
                }

                if (palya[ujY][ujX] == 'V') {
                    if (nyilakSzama > 0) {
                        System.out.println("A nyílak számát csökkentették, mert beleléptél a verembe.");
                        nyilakSzama--;
                        palya[hosY][hosX] = ' '; // Verem eltűnése
                        palya[ujY][ujX] = 'H'; // Hős megjelenése a verem helyén
                    } else {
                        System.out.println("Nincs több nyíl, amiből le lehet vonni, mert beleléptél a verembe!");
                        felad = true;
                        returnToMainMenu();
                    }
                    continue;
                }

                // Mozgás végrehajtása
                palya[ujY][ujX] = 'H';
                palya[hosY][hosX] = ' ';
                hosX = ujX;
                hosY = ujY;
                lepesMennyiseg++;

                checkGameEnd();
                continue;
            }

            if (parancs.equals("lő")) {
                lo();
                continue;
            }

            if (parancs.equals("balra") || parancs.equals("jobbra") || parancs.equals("fel") || parancs.equals("le")) {
                irany = parancs;
                System.out.println("Most a hős " + irany + " irányba néz.");
            } else {
                System.out.println("Nem érvényes irány vagy parancs. Kérlek válassz a lehetőségek közül.");
            }
        }
    }


    public void lo() {
        if (nyilakSzama > 0) {
            int x = hosX;
            int y = hosY;
            while (true) {
                switch (irany) {
                    case "egyenes", "jobbra" -> x++;
                    case "balra" -> x--;
                    case "fel" -> y--;
                    case "le" -> y++;
                }

                if (x < 0 || x >= Palya.N || y < 0 || y >= Palya.N) {
                    System.out.println("A nyíl a pálya szélét találta el.");
                    nyilakSzama--;
                    break;
                }

                if (palya[y][x] == 'F') {
                    System.out.println("A nyíl eltalálta a falat.");
                    nyilakSzama--;
                    break;
                }

                if (palya[y][x] == 'W') {
                    System.out.println("A nyíl eltalálta a Wumpuszt!");
                    palya[y][x] = ' ';
                    nyilakSzama--;
                    checkGameEnd();
                    break;
                }
            }
        } else {
            System.out.println("Elfogyott a nyíl.");
        }
    }

    public void checkGameEnd() {
        if (palya[hosY][hosX] == 'W') {
            System.out.println("Meghaltál, mert rá léptél egy Wumpuszra.");
            felad = true;
            returnToMainMenu();
        } else if (palya[hosY][hosX] == 'V') {
            if (nyilakSzama > 0) {
                System.out.println("A nyílak számát csökkentették, mert beleléptél a verembe.");
                nyilakSzama--;
            } else {
                System.out.println("Nincs több nyíl, amiből le lehet vonni, mert beleléptél a verembe!");
                felad = true;
                returnToMainMenu();
            }
        } else if (palya[hosY][hosX] == 'A') {
            System.out.println("Gratulálunk, megszerezted az aranyat!");
            felad = true;
            returnToMainMenu();
        }
    }

    public void returnToMainMenu() {
        AlapMenu.alapMenu();
    }
}