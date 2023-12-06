package wumpusz.Hozzaadas;

import wumpusz.Szerkesztes.Palya;

import java.util.Scanner;

import static wumpusz.Szerkesztes.Palya.palya;

public class AranyHozzaad {
    public static int aranySzamlalo = 1;
        public static void aranyHozzadas() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Add meg az arany pozícióját egyben (1. abc betui 2. egész szám) ");
            String position = scanner.nextLine().toUpperCase();
            if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
                System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
                return;
            }

            int x = position.charAt(0) - 'A' + 1;
            int y = Character.getNumericValue(position.charAt(1));

            if (x < 1 || x >= Palya.N - 1 || y < 1 || y >= Palya.N - 1) {
                System.out.println("Az Arany nem helyezhető a szélekhez közel.");
                return;
            }

            if (palya[y][x] == ' ') {
                palya[y][x] = 'A';
                aranySzamlalo--;
                System.out.println("Arany hozzáadva");
            } else {
                System.out.println("A megadott pozíció már foglalt, vagy nem helyezhető oda az arany. Válassz másik pozíciót!");
            }
        }
    }
