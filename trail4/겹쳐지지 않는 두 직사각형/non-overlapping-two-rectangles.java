import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int r1=0; r1<N; r1++) {
            for (int c1=0; c1<M; c1++) {
                for (int r2=r1; r2<N; r2++) {
                    for (int c2=c1; c2<M; c2++) {
                        visited = new boolean[N][M];
                        int width = calWidth(r1, c1, r2, c2);
                        
                        for (int r3=0; r3<N; r3++) {
                            for (int c3=0; c3<M; c3++) {
                                for (int r4=r3; r4<N; r4++) {
                                    for (int c4=c3; c4<M; c4++) {
                                        explore(r3, c3, r4, c4, width);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(maxResult);
    }

    static int calWidth(int r1, int c1, int r2, int c2) {
        int sum = 0;

        for (int r=r1; r<=r2; r++) {
            for (int c=c1; c<=c2; c++) {
                sum += map[r][c];
                visited[r][c] = true;
            }
        }

        return sum;
    }

    static void explore(int r3, int c3, int r4, int c4, int width) {
        int sum=0;
        
        for (int r=r3; r<=r4; r++) {
            for (int c=c3; c<=c4; c++) {
                if (visited[r][c]) {
                    return;
                }

                sum += map[r][c];
            }
        }

        maxResult = Math.max(maxResult, sum + width);
    }
}