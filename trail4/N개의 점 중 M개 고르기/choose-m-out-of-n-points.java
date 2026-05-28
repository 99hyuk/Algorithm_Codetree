import java.util.*;

public class Main {

    static int n,m;
    static int[][] points;
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        visited = new boolean[n];
        recursive(0,0);

        System.out.print(minValue);
    }

    static void recursive(int idx, int cnt) {
        if (cnt > m) {
            return;
        }

        if (idx == n) {
            if (cnt == m) {
                int farDist = Integer.MIN_VALUE;

                for (int i=0; i<n; i++) {
                    if (visited[i]) {
                        for (int j=0; j<n; j++) {
                            if (visited[j] && j != i) {
                                farDist = Math.max(farDist, calDist(i, j));
                            }
                        }
                    }
                }

                minValue = Math.min(minValue, farDist);
            }
            return;
        }

        recursive(idx+1, cnt);

        visited[idx] = true;
        recursive(idx+1, cnt+1);
        visited[idx] = false;
    }

    static int calDist(int idx1, int idx2) {
        int r1 = points[idx1][0];
        int c1 = points[idx1][1];

        int r2 = points[idx2][0];
        int c2 = points[idx2][1];

        int reuslt = (int) (Math.pow(r1-r2, 2) + Math.pow(c1-c2, 2));

        return reuslt;
    }
}