import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int maxWidth = -1;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int r1=0; r1<N; r1++) {
            for (int c1=0; c1<M; c1++) {
                for (int r2=r1; r2<N; r2++) {
                    for (int c2=c1; c2<M; c2++) {
                        culWidth(r1,c1,r2,c2);
                    }
                } 
            }
        }

        System.out.print(maxWidth);
    }

    static void culWidth(int r1, int c1, int r2, int c2) {
        int width = 0;

        for (int r=r1; r<=r2; r++) {
            for (int c=c1; c<=c2; c++) {
                if (map[r][c] <= 0) return;

                width += 1;
            }
        }

        maxWidth = Math.max(maxWidth, width);
    }
}