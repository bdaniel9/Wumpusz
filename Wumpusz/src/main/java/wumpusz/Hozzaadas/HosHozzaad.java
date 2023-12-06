package wumpusz.Hozzaadas;

import wumpusz.Szerkesztes.Palya;

import java.util.Scanner;

import static wumpusz.Szerkesztes.Palya.palya;

public class HosHozzaad {
        public static int hosSzamlalo = 1;
    private int hosPozX;
    private int hosPozY;

    public int getHosPozX() {
        return hosPozX;
    }

    public int getHosPozY() {
        return hosPozY;
    }

    public void hosHozzadas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg a HŐS pozícióját egyben (1. abc betui 2. egész szám): ");
        String position = scanner.nextLine().toUpperCase();
        if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
            System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
            return;
        }

        hosPozX = position.charAt(0) - 'A' + 1;
        hosPozY = Character.getNumericValue(position.charAt(1));

        if (hosPozX < 1 || hosPozX >= Palya.N - 1 || hosPozY < 1 || hosPozY >= Palya.N - 1) {
            System.out.println("A Hős nem helyezhető a szélekhez közel.");
            return;
        }

        if (palya[hosPozY][hosPozX] == ' ') {
            palya[hosPozY][hosPozX] = 'H';
            hosSzamlalo--;
            System.out.println("HŐS hozzáadva!");
        } else {
            System.out.println("A megadott pozíció már foglalt.Válassz másik pozíciót");
        }
    }
}

