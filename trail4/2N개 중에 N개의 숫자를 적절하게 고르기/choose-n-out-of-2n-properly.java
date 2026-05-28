import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int minValue = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n*2];
        for (int i=0 ; i<2*n; i++) {
            arr[i] = sc.nextInt();
        }

        visited = new boolean[2*n];
        recursive(0, 0);

        System.out.print(minValue);
    }

    static void recursive(int idx, int cnt) {
        if (cnt > n) {
            return;
        } 

        if (idx == 2*n) {
            if (cnt == n) {
                int sum1 = 0;
                int sum2 = 0;

                for (int i=0; i<2*n; i++) {
                    if (visited[i]) {
                        sum1 += arr[i];
                    } else {
                        sum2 += arr[i];
                    }
                }

                minValue = Math.min(minValue, Math.abs(sum1 - sum2));
            }
            return;
        }

        recursive(idx+1, cnt);

        visited[idx] = true;
        recursive(idx+1, cnt+1);
        visited[idx] = false;
    }
}