import java.util.*;

public class Main {
    
    static int n,m;
    static int maxValue = 0;
    static int[] arr;
    static List<Integer> selected;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        selected = new ArrayList<>();

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        recursive(0, 0);
        System.out.print(maxValue);
    }

    static void recursive(int idx, int cnt) {
        if (idx == n) {
            if (cnt == m) {
                checkXor();
            }
            return;
        }

        selected.add(arr[idx]);
        recursive(idx+1, cnt+1);
        selected.remove(selected.size()-1);

        recursive(idx+1, cnt);
    }

    static void checkXor() {
        int result = 0;
        for (int num : selected) {
            result ^= num;
        }

        maxValue = Math.max(maxValue, result);
    }
}