import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dirMap;
    static int[][] direction = {{0,0}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
    static int startR, startC;
    static int maxCount = 0;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dirMap = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                dirMap[i][j] = sc.nextInt();
            }
        }

        startR = sc.nextInt()-1;
        startC = sc.nextInt()-1;

        dfs(startR, startC, 0);

        System.out.print(maxCount);
    }

    static void dfs(int r, int c, int count) {
        maxCount = Math.max(maxCount, count);

        int dir = dirMap[r][c];
        int dr = direction[dir][0];
        int dc = direction[dir][1];
        int nr = r;
        int nc = c;

        for (int i=0; i<N; i++) {
            nr += dr;
            nc += dc;

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (map[r][c] >= map[nr][nc]) continue;

            dfs(nr, nc, count+1);
        }
    }
}