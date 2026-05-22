import java.util.*;
public class Main {

    static int n, m, C, grid[][];
    static boolean[] selected;
    static int cost1 = 0;
    static int cost2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        C = sc.nextInt();
        grid = new int[n][n];
        selected = new boolean[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        int maxCost = 0;
        for (int r1=0; r1<n; r1++) {
            for (int c1=0; c1<n; c1++) {

                if (c1 + m > n) continue;
                cost1 = 0;

                recursive1(0, r1, c1);

                for (int r2=r1; r2<n; r2++) {
                    int nextC = r2 == r1 ? c1+m : 0;
                    for (int c2=nextC; c2<n; c2++) {

                        if (c2 + m > n) continue;
                        cost2 = 0;

                        recursive2(0, r2, c2);

                        maxCost = Math.max(maxCost, cost1 + cost2);

                    }
                }
            }
        }

        System.out.print(maxCost);
    }

    static void recursive1(int idx, int r, int c) {
        if (idx == m) {

            int sum = 0;
            int cost = 0;

            for (int i=0; i<m; i++) {
                if(selected[i]) {
                    sum += grid[r][c+i];
                    cost += grid[r][c+i] * grid[r][c+i];
                }
            }

            if (sum > C) return;
            else {
                cost1 = Math.max(cost, cost1);
                return;
            }
        }

        selected[idx] = true;
        recursive1(idx+1, r, c);
        selected[idx] = false;
        recursive1(idx+1, r, c);
    }

    static void recursive2(int idx, int r, int c) {
        if (idx == m) {

            int sum = 0;
            int cost = 0;

            for (int i=0; i<m; i++) {
                if(selected[i]) {
                    sum += grid[r][c+i];
                    cost += grid[r][c+i] * grid[r][c+i];
                }
            }

            if (sum > C) return;
            else {
                cost2 = Math.max(cost, cost2);
                return;
            }
        }

        selected[idx] = true;
        recursive2(idx+1, r, c);
        selected[idx] = false;
        recursive2(idx+1, r, c);
    }
}