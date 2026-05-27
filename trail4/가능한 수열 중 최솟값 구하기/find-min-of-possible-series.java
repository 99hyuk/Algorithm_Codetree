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

        if (idx >= 6) {
            boolean check = true;
            for (int i=0; i<3; i++) {
                if (arr[idx-6+i] != arr[idx-3+i]) {
                    check = false;
                }
            }

            if(check) return;
        } 
        
        if (idx >= 4) {
            boolean check = true;
            for (int i=0; i<2; i++) {
                if (arr[idx-4+i] != arr[idx-2+i]) {
                    check = false;
                }
            }

            if(check) return;
        }

        if (idx >= 2) {
           if (arr[idx-2] == arr[idx-1]) return;
        }

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

    static boolean check(int idx) {
        if (idx >= 6) {
            boolean check = true;
            for (int i=0; i<3; i++) {
                if (arr[idx-6+i] != arr[idx-3+i]) {
                    check = false;
                }
            }

            if(check) return;
        } 
        
        if (idx >= 4) {
            boolean check = true;
            for (int i=0; i<2; i++) {
                if (arr[idx-4+i] != arr[idx-2+i]) {
                    check = false;
                }
            }

            if(check) return;
        }

        if (idx >= 2) {
           if (arr[idx-2] == arr[idx-1]) return;
        }
    }
}