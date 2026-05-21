import java.util.*;

class Point {
    int r;
    int c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int N, M;
    static int[][] map;
    static int maxGoldCnt = 0;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); // 금 한 개 가격

        map = new int[N][N];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                bfs(i,j);
            }
        }

        System.out.print(maxGoldCnt);
    }

    public static void bfs(int r, int c) {
        Queue<Point> Q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        Q.offer(new Point(r, c));
        visited[r][c] = true;

        int goldCost = 0;
        int drillCost = 1;
        int goldCnt = 0;

        if(map[r][c] == 1) {
            goldCost += M;
            goldCnt++;
        }

        if (goldCost - drillCost >= 0) {
            maxGoldCnt = Math.max(maxGoldCnt, goldCnt);
        }

        int k = 1;

        while(!Q.isEmpty()) {
            int size = Q.size();

            for (int i=0; i<size; i++) {
                Point p = Q.poll();

                for (int dir=0; dir<4; dir++) {
                    int nr = p.r + dr[dir];
                    int nc = p.c + dc[dir];

                    if (!isIn(nr,nc)) continue;
                    if (visited[nr][nc]) continue;

                    Q.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 1) {
                        goldCost += M;
                        goldCnt++ ;
                    }
                }
            }

            if (goldCost  - (k*k + (k+1)*(k+1)) >= 0) {
                maxGoldCnt = Math.max(maxGoldCnt, goldCnt);
            }

            k++;

        }
    }

    static boolean isIn(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N; 
    }
}