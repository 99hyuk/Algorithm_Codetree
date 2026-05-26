import java.util.*;

public class Main {

    static int n, m, k;
    static int[] played, selected, moved;
    static int maxScore = 0;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        selected = new int[n]; // 턴
        for (int i=0; i<n; i++) {
            selected[i] = sc.nextInt();
        }

        played = new int[n]; // 말 순서
        moved = new int[k]; // 총 달린 거리 기록

        recursive(0);
        System.out.print(maxScore);
    }

    static void recursive(int idx) {
        if (idx == n) {
            simulation();
            return;
        }

        for (int i=0; i<k; i++) {
            played[idx] = i;
            recursive(idx+1);
        }
    }

    static void simulation() {
        for (int i=0; i<n; i++) {
            moved[played[i]] += selected[i]; 
        }

        int score = 0;
        for (int i=0; i<k; i++) {
            if (moved[i] >= m-1) {
                score++;
            }
        }

        moved = new int[k];

        maxScore = Math.max(score, maxScore);
    }
}