import java.util.*;

class Sunbun implements Comparable<Sunbun> {

    int l;
    int r;

    Sunbun(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Sunbun o) {
        return Integer.compare(this.l, o.l);
    }
}

public class Main {
    
    static int N;
    static int max = 0;
    static boolean[] checked;
    static List<Sunbun> list = new ArrayList<>();

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i=0; i<N; i++) {
            list.add(new Sunbun(sc.nextInt(), sc.nextInt()));
        }

        checked = new boolean[N];
        Collections.sort(list);

        dfs(0);
        System.out.print(max);
    }

    static void dfs(int idx) {
        if (idx==N) {
            simulation();
            return;
        }

        checked[idx] = true;
        dfs(idx+1);
        checked[idx] = false;
        dfs(idx+1);
    }

    static void simulation() {
        int maxR = 0;
        int cnt = 0;

        for (int i=0; i<N; i++) {
            if (checked[i]) {
                if (maxR >= list.get(i).l) {
                    return;
                } else {
                    maxR = list.get(i).r;
                    cnt++;
                }
            }
        }

        max = Math.max(max, cnt);
    }
}