import java.util.*;

public class Main {

    static int n,m;
    static int[] arr;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        recursive(0);
    }

    static void recursive(int idx) {
        if (idx == m) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=n; i++) {
            if (idx > 0) {
                if (arr[idx-1] >= i) continue;
            } 
            
            arr[idx] = i;
            recursive(idx+1);
        }
    }
}