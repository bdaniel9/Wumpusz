package wumpusz.Hozzaadas;

import wumpusz.Szerkesztes.Palya;

import java.util.Scanner;

public class VeremHozzaad {
    public static void veremHozzaad(char verem){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg a pozíciót egyben (1. abc betui 2. egész szám):");
        String position = scanner.nextLine().toUpperCase();
        if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
            System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
            return;
        }

        int x = position.charAt(0) - 'A' + 1;
        int y = Character.getNumericValue(position.charAt(1));

        if (x < 1 || x >= Palya.N - 1 || y < 1 || y >= Palya.N - 1) {
            System.out.println("Nem módosíthatsz a szélekhez vagy a falhoz közeli pozíciókat(falon tuliakat sem).");
            return;
        }

        if (Palya.palya[y][x] == ' ') {
            Palya.palya[y][x] = verem;
        } else {
            System.out.println("A megadott pozíció már foglalt.Válassz másik pozíciót");
        }
    }
}
