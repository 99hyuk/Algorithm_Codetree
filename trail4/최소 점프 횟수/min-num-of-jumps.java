import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(1,0);

        if (minValue == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(minValue);
        }
    }
    

    static void dfs(int pos, int cnt) {
        if (cnt >= minValue) return;

        if (pos >= n) {
            minValue = Math.min(minValue, cnt);
            return;
        }

        int jump = arr[pos];
        for (int i=1; i<=jump; i++) {
            dfs(pos+i, cnt+1);
        }
    }
}