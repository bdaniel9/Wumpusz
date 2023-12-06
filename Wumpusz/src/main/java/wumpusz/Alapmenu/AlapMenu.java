package wumpusz.Alapmenu;

import wumpusz.Jatek.Jatek;
import wumpusz.Szerkesztes.Palyaszerkeszto;

import java.util.Scanner;

public class AlapMenu {
    private static boolean kilep=false;
    public static void alapMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a felhasználóneved:");
        String felhasznalonev = scanner.nextLine();
        System.out.println("Üdvözöllek "+felhasznalonev);


        while (!kilep) {
            System.out.println(
                    "Alap menü:\n" +
                            "1. Pályaszerkesztés\n" +
                            "2. Adatbázisól betöltés\n" +
                            "3. Adatbázisba mentés\n" +
                            "4. Játsz\n" +
                            "5. Kilépés\n"
            );

            int valasz = scanner.nextInt();
            switch (valasz) {
                case 1: {
                    System.out.println("Pályaszerkesztés elkezdődött");
                    Palyaszerkeszto.palyaszerkeszto();
                }
                case 2 : System.out.println("Adatbázisból betöltés");
                case 3 : {
                    System.out.println("Adatbázisba mentés...");
                }
                case 4 : {
                    System.out.println("Játék indítás!");
                    Jatek jatek = new Jatek();
                    jatek.inditas();
                }
                case 5 : {
                    kilep = true;
                    System.out.println("Kiléptél a játékból!");
                }
            }
        }
    }
    public void setPalyaszerkeszto(Palyaszerkeszto mockPalyaszerkeszto) {
        return;
    }

    public void setJatek(Jatek mockJatek) {
    }


}
