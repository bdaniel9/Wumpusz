package Wumpusz.Alapmenu;

import Wumpusz.Jatek.Jatek;
import Wumpusz.Szerkesztes.Palyaszerkeszto;

import java.util.Scanner;

public class AlapMenu {
    private static boolean kilep=false;
    public static void alapMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a felhasználóneved:");
        String felhasznalonev = scanner.nextLine();
        System.out.println("Üdvözöllek "+felhasznalonev);

        while (!kilep){
        System.out.println("""
                Alap menü:
                1. Pályaszerkesztés
                2. Adatbázisól betöltés
                3. Adatbázisba mentés
                4. Játsz
                5. Kilépés
                """);

            int valasz = scanner.nextInt();
            switch (valasz){
                case 1:
                    System.out.println("Pályaszerkesztés elkezdődött");
                    Palyaszerkeszto.palyaszerkeszto();
                    break;
                case 2:
                    System.out.println("mentés");
                    break;
                case 3:
                    System.out.println("betöltés");
                    break;
                case 4:
                    System.out.println("Játék indítás!");
                    Jatek jatek = new Jatek();
                    jatek.inditas();
                    break;
                case 5:
                    kilep=true;
                    System.out.println("Kiléptél a kjátékból!");
            }
        }
    }
}
