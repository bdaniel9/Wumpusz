package wumpusz.Szerkesztes;

import wumpusz.Alapmenu.AlapMenu;
import wumpusz.Hozzaadas.*;

import java.util.Scanner;

import static wumpusz.Szerkesztes.Palya.palyaKiiratas;

public class Palyaszerkeszto {
    public static void palyaszerkeszto(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Add meg a pálya méretét (N):");
            Palya.N=Integer.parseInt(scanner.next());
            if (Palya.N<6 || Palya.N>20){
                System.out.println("A pálya mérete túl kicsi/nagy. 6 és 20 közötti számot adj meg!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Nem helyes érték van megadva");
            return;
        }
        Palya.palyaInicializalasa();
        palyaKiiratas();

        boolean szerkesztesBefejezes = true;
        while (szerkesztesBefejezes) {
            System.out.println(
                    "Szerkesztési lehetőségek:\n\n" +
                            "1. Fal hozzáadása\n" +
                            "2. Verem hozzáadása\n" +
                            "3. Wumpusz hozzáadása (" + WumpuszHozzaad.wumpuszSzamlalo + ")\n" +
                            "4. Arany hozzáadás (" + AranyHozzaad.aranySzamlalo + ")\n" +
                            "5. Hős hozzáadása (" + HosHozzaad.hosSzamlalo + ")\n" +
                            "6. Szerkesztés befejezés\n"
            );

            int valasztas = scanner.nextInt();
            switch (valasztas){
                case 1:
                    FalHozzaad.falHozzaad('F');
                    break;
                case 2:
                    VeremHozzaad.veremHozzaad('V');
                    break;
                case 3:
                    if (WumpuszHozzaad.wumpuszSzamlalo>0){
                        WumpuszHozzaad.wumpuszHozzaad();
                    }
                    else {
                        System.out.println("Nem tudsz több Wumpusz-t hozzáadni");
                    }
                    break;
                case 4:
                    if (AranyHozzaad.aranySzamlalo>0){
                        AranyHozzaad.aranyHozzadas();
                    }
                    else {
                        System.out.println("Nem tudsz több Arany-at hozzáadni");
                    }
                    break;
                case 5:
                    if (HosHozzaad.hosSzamlalo>0){
                        HosHozzaad.hosHozzadas();
                    }
                    else {
                        System.out.println("Nem tudsz több Hős-t hozzáadni");
                    }
                    break;
                case 6:
                    System.out.println("Szerkesztés befejezve!");
                    szerkesztesBefejezes = false;
                    AlapMenu.alapMenu();
                    //break;
                    return;
                default:
                    System.out.println("Adj meg 1 és 6 közötti értéket! Hibás értéket adtál meg.");
                    break;
            }
            palyaKiiratas();
        }
    }
}
