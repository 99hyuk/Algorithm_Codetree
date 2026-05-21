import java.util.*;

class Ladder implements Comparable<Ladder> {
    int left;
    int right;
    int height;
    public Ladder (int left, int right, int height) {
        this.left = left;
        this.right = right;
        this.height = height;
    }

    @Override
    public int compareTo(Ladder o) {
        return Integer.compare(this.height, o.height);
    }
}

public class Main {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static List<Ladder> dist;
    static boolean[] selected;
    static int[] finalSelected;
    static int[] correctSelected;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dist = new ArrayList<>();
        selected = new boolean[M];
        finalSelected = new int[N+1];
        correctSelected = new int[N+1];

        for (int i=0; i<M; i++) {
            int left = sc.nextInt();
            int height = sc.nextInt();
            dist.add(new Ladder(left, left+1, height));
        }

        Collections.sort(dist);
        
        for (int i=1; i<=N; i++) {
            exploreCorrect(i, i, 0);
        }

        dfs(0);

        System.out.print(min);
        // System.out.print(Arrays.toString(correctSelected));
    }

    static void dfs(int idx) {
        if (idx == M) {
            simulation();
            return;
        }

        selected[idx] = true;
        dfs(idx+1);
        selected[idx] = false;
        dfs(idx+1);
    }

    static void simulation() {
        for (int i=1; i<=N; i++) {
            explore(i, i, 0);
        }

        int count = 0;
        for (int i=0; i<selected.length; i++) {
            if (selected[i]) count++;
        }

        boolean check = true;
        for (int i=1; i<=N; i++) {
            if (finalSelected[i] != correctSelected[i]) {
                check = false;
            }
        }

        if (check) {
            min = Math.min(min, count);
        }
    }

    static void explore(int num, int curPos, int curHeight) { // 세로 위치 1~N , 가로 위치(높이) 1~b

        for (int i=0; i<M; i++) {
            if (selected[i]) {
                if (dist.get(i).left == curPos || dist.get(i).right == curPos) {
                    if (dist.get(i).height >= curHeight) {
                        if (dist.get(i).left == curPos) {
                            explore(num, dist.get(i).right, dist.get(i).height+1);
                        } else {
                            explore(num, dist.get(i).left, dist.get(i).height+1);
                        }
                        return;
                    }
                }
            }
        }

        finalSelected[curPos] = num;
    }

    static void exploreCorrect(int num, int curPos, int curHeight) { // 세로 위치 1~N , 가로 위치(높이) 1~b

        for (int i=0; i<M; i++) {
            if (dist.get(i).left == curPos || dist.get(i).right == curPos) {
                if (dist.get(i).height >= curHeight) {
                    if (dist.get(i).left == curPos) {
                        exploreCorrect(num, dist.get(i).right, dist.get(i).height+1);
                    } else {
                        exploreCorrect(num, dist.get(i).left, dist.get(i).height+1);
                    }
                    return;
                }
            }
        }

        correctSelected[curPos] = num;
    }
}