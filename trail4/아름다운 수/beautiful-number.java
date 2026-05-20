import java.util.*;

public class Main {

    static int N;
    static int cnt = 0;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        recursive(0);
        System.out.print(cnt);
    }

    public static void recursive(int idx) {
        if (idx == N) {
            cnt++;
            return;
        }

        for (int num=1; num<=4; num++) {
            if (num == 1) {
                recursive(idx+1);
            } else if (num == 2) {
                if (idx+2 > N) continue;
                recursive(idx+2);
            } else if (num == 3) {
                if (idx+3 > N) continue; 
                recursive(idx+3);
            } else if (num == 4) {
                if (idx+4 > N) continue;
                recursive(idx+4);
            }
         }
    }
}