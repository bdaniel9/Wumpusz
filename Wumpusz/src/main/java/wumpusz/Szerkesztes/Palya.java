package wumpusz.Szerkesztes;

public class Palya {
    public static int N;
    public static char[][] palya;

    public static void palyaInicializalasa() {
        palya = new char[N + 1][N + 1];

        // Az első oszlop feltöltése abc betűivel, egy sorral lejjebb
        for (int j = 1; j < N; j++) {
            palya[j][0] = (char) ('0' + j);
        }

        // A nulladik sor feltöltése számokkal
        for (int i = 1; i < N; i++) {
            palya[0][i] = (char)('a' + i - 1);
        }

        // A többi rész inicializálása
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == N || j == N) {
                    palya[i][j] = '-';
                } else {
                    palya[i][j] = ' ';
                }
            }
        }
    }

    public static void palyaKiiratas() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(palya[i][j] + " ");
            }
            System.out.println();
        }
    }
}
