import java.util.*;
import java.io.*;

public class Main {
   
    static int N, M, map[][];
    static int max = Integer.MIN_VALUE;
  
    public static void main(String[] args) throws Exception {
        // Please write your code here.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } 

        block1();
        block2();

        System.out.print(max);
    }

    public static void block1 () {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                for (int c=j; c<=j+2; c++) {
                    if (j+2 >= M) break;
                    sum += map[i][c];
                }

                max = Math.max(max, sum);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                for (int c=i; c<=i+2; c++) {
                    if (i+2 >= N) break;
                    sum += map[c][j];
                }

                max = Math.max(max, sum);
            }
        }
    }

    public static void block2 () {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                if (j+1 >= M || i+1 >= N) break;

                sum = map[i][j] + map[i+1][j] + map[i+1][j+1];
                max = Math.max(max, sum);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                if (j+1 >= M || i-1 < 0) break;

                sum = map[i][j] + map[i][j+1] + map[i-1][j+1];
                max = Math.max(max, sum);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                if (j+1 >= M || i+1 >= N) break;

                sum = map[i][j] + map[i][j+1] + map[i+1][j+1];
                max = Math.max(max, sum);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int sum = 0;
                if (j+1 >= M || i+1 >= N) break;

                sum = map[i][j] + map[i+1][j] + map[i][j+1];
                max = Math.max(max, sum);
            }
        }
    }
}