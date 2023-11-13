package Wumpusz.Hozzaadas;

import Wumpusz.Szerkesztes.Palya;

import java.util.Scanner;

import static Wumpusz.Szerkesztes.Palya.palya;

public class hosHozzaad {
        public static int hosSzamlalo = 1;
        static int hosPozX;
        static int hosPozY;

    public static void hosHozzadas() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Add meg az arany pozícióját (pl. 'c3'): ");
            String position = scanner.nextLine().toUpperCase();
            if (position.length() != 2 || !Character.isLetter(position.charAt(0)) || !Character.isDigit(position.charAt(1))) {
                System.out.println("Érvénytelen pozíció formátum. Használj pl. 'a1' formátumot.");
                return;
            }

            hosPozX = position.charAt(0) - 'A' + 1;
            hosPozY = Character.getNumericValue(position.charAt(1));

            if (hosPozX < 1 || hosPozX >= Palya.N - 1 || hosPozY < 1 || hosPozY >= Palya.N - 1) {
                System.out.println("Az Arany nem helyezhető a szélekhez közel.");
                return;
            }

            if (palya[hosPozY][hosPozX] == ' ') {
                palya[hosPozY][hosPozX] = 'H';
                hosSzamlalo--;
                System.out.println("HŐS hozzáadva!");
            } else {
                System.out.println("A megadott pozíció már foglalt.");
            }
        }
    public int getHosPozX() {
        return hosPozX;
    }

    public int getHosPozY() {
        return hosPozY;
    }
    }

