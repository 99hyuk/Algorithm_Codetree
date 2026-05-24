import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int maxResult = 0;
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};

    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int d1=1; d1<N; d1++) {
                    for (int d2=1; d2<N; d2++) {
                        simulation(i,j,d1,d2);
                    }
                }
            }
        }

        System.out.print(maxResult);

    }

    static void simulation(int r, int c, int d1, int d2) {
        int result = 0;
        int nr = r;
        int nc = c;

        for (int i=0; i<4; i++) {
            if (i%2 == 0) {
                for (int d=0; d<d1; d++) {
                    nr = nr + dr[i];
                    nc = nc + dc[i];

                    if (!isIn(nr,nc)) return;

                    result += map[nr][nc];
                }
            } else {
                for (int d=0; d<d2; d++) {
                    nr = nr + dr[i];
                    nc = nc + dc[i];

                    if (!isIn(nr,nc)) return;

                    result += map[nr][nc];
                }
            }
        }

        maxResult = Math.max(maxResult, result);
    }

    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }
}