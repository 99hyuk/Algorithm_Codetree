import java.util.*;

public class Main {

    static int N, K;
    static int arr[];

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        arr = new int[N];
        recursive(0);
    }

    public static void recursive(int idx) {
        if (idx == N) {
            for (int i=0; i<N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=K; i++) {
            arr[idx] = i;
            recursive(idx+1);
        }
    }
}