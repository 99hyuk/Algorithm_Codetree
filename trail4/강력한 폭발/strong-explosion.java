import java.util.*;

public class Main {

    static int N;
    static int count;
    static int max = 0;
    static int[] arr;
    static int[][] map;
    static int[][] bombMap;
    
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        count = 0;

        map = new int[N][N];
        bombMap = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        arr = new int[count];
        dfs(0);

        System.out.print(max);
    }

    static void dfs(int idx) {
        if (idx == count) {
            simulation();
            return;
        } 
        for (int i=1; i<=3; i++) {
            arr[idx] = i;
            dfs(idx+1);
        }
    }

    static void simulation() {
        int idx = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1) {
                    bombMap[i][j] = 1;
                    bomb(arr[idx++], i, j);
                }
            }
        }

        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (bombMap[i][j] == 1) cnt++;
            }
        }

        max = Math.max(max, cnt);

        backSimul();
    }

    static void bomb(int idx, int r, int c) {
        if (idx == 1) {
            if (r-1 >= 0) bombMap[r-1][c] = 1;
            if (r-2 >= 0) bombMap[r-2][c] = 1;
            if (r+1 < N) bombMap[r+1][c] = 1;
            if (r+2 < N) bombMap[r+2][c] = 1;

        } else if (idx == 2) {
            if (r-1 >= 0) bombMap[r-1][c] = 1;
            if (c-1 >= 0) bombMap[r][c-1] = 1;
            if (c+1 < N) bombMap[r][c+1] = 1;
            if (r+1 < N) bombMap[r+1][c] = 1;

        } else if (idx == 3) {
            if (c-1 >= 0 && r-1 >= 0) bombMap[r-1][c-1] = 1;
            if (c+1 < N && r-1 >= 0) bombMap[r-1][c+1] = 1;
            if (c-1 >= 0 && r+1 < N) bombMap[r+1][c-1] = 1;
            if (c+1 < N && r+1 < N) bombMap[r+1][c+1]= 1;
        }
    }

    static void backSimul() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                bombMap[i][j] = 0;
            }
        }
    }
}