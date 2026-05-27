import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean finish = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        dfs(0);
    }

    static void dfs(int idx) {
        if(finish) return;

        if(condition(idx)) return;

        if (idx == n) {
            for (int n : arr) {
                System.out.print(n);
            }
            finish = true;
            return;
        }

        arr[idx] = 4;
        dfs(idx+1);
        arr[idx] = 5;
        dfs(idx+1);
        arr[idx] = 6;
        dfs(idx+1);
    }

    static boolean condition(int idx) {
        for (int i=2; i<=idx; i+=2) {
            boolean check = true;
            for (int j=0; j<i/2; j++) {
                if (arr[idx-i+j] != arr[idx-i/2+j]) {
                    check = false;
                }
            }
            if(check) return true;
        }

        return false;
    }
}