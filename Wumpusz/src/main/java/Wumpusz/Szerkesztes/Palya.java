package Wumpusz.Szerkesztes;

public class Palya {
    public static int N;
    public static char[][] palya;

    public static void palyaInicializalasa() {
        palya = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                    palya[i][j] = '-';
                } else {
                    palya[i][j] = ' ';
                }
            }
        }
    }

    public static void palyaKiiratas() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(palya[i][j] + " ");
            }
            System.out.println();
        }
    }
}
