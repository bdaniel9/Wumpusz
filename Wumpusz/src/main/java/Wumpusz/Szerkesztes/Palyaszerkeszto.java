package Wumpusz.Szerkesztes;

import Wumpusz.Hozzaadas.*;

import java.util.Scanner;

import static Wumpusz.Szerkesztes.Palya.palyaKiiratas;

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
        while(szerkesztesBefejezes){
            System.out.println("""
                    Szerkesztési lehetőségek:
                    
                    1. Fal hozzáadása
                    2. Verem hozzáadása
                    3. Wumpusz hozzáadása ("""+ wumpuszHozzaad.wumpuszSzamlalo+"""
                    )
                    4. Arany hozzáadás ("""+ aranyHozzaad.aranySzamlalo+"""
                    )
                    5. Hős hozzáadása ("""+ hosHozzaad.hosSzamlalo+"""
                    )
                    6. Szerkesztés befejezés
                    """);

            int valasztas = scanner.nextInt();
            switch (valasztas){
                case 1:
                    FalHozzaad.falHozzaad('F');
                    break;
                case 2:
                    VeremHozzaad.veremHozzaad('V');
                    break;
                case 3:
                    if (wumpuszHozzaad.wumpuszSzamlalo>0){
                        wumpuszHozzaad.wumpuszHozzaad();
                    }
                    else {
                        System.out.println("Nem tudsz több Wumpusz-t hozzáadni");
                    }
                    break;
                case 4:
                    if (aranyHozzaad.aranySzamlalo>0){
                        aranyHozzaad.aranyHozzadas();
                    }
                    else {
                        System.out.println("Nem tudsz több Arany-at hozzáadni");
                    }
                    break;
                case 5:
                    if (hosHozzaad.hosSzamlalo>0){
                        hosHozzaad.hosHozzadas();
                    }
                    else {
                        System.out.println("Nem tudsz több Hős-t hozzáadni");
                    }
                    break;
                case 6:
                    System.out.println("Szerkesztés befejezve!");
                    szerkesztesBefejezes = false;
                    break;
                default:
                    System.out.println("Adj meg 1 és 6 közötti értéket! Hibás értéket adtál meg.");
                    break;
            }
            palyaKiiratas();
        }
    }
}
