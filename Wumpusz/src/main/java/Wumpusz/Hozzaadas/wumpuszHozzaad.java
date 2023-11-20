package Wumpusz.Hozzaadas;

import Wumpusz.Szerkesztes.Palya;

import java.util.Scanner;

import static Wumpusz.Szerkesztes.Palya.palya;

public class wumpuszHozzaad {
        public static int wumpuszSzamlalo = Palya.N <= 8 ? 1 : (Palya.N <= 14 ? 2 : 3);
        public static int nyilakSzama=wumpuszSzamlalo;

        public static void wumpuszHozzaad() {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Add meg a WUMPUSZ kezdő pozíciójátegyben (1. abc betui 2. egész szám): ");
            String position = scanner.nextLine().toUpperCase();
            if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
                System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
                return;
            }

            int x = position.charAt(0) - 'A' + 1;
            int y = Character.getNumericValue(position.charAt(1));

            if (x < 1 || x >= Palya.N - 1 || y < 1 || y >= Palya.N - 1) {
                System.out.println("A WUMPUSZ nem helyezhető a szélekhez közel.");
                return;
            }

            if (palya[y][x] == ' ') {
                palya[y][x] = 'W';
                wumpuszSzamlalo--;
                System.out.println("Wumpusz hozzáadva");
            } else {
                System.out.println("A megadott pozíció már foglalt, vagy nem helyezhető oda wumpusz.Válassz másik pozíciót");
            }
        }
}
