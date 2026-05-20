import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {  
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int happyArr = 0;

        for (int i=0; i<N; i++) {
            int temp = 0;
            for (int j=0; j<N; j++) {
                if (j == 0) {
                    temp = 1;
                } else {
                    if (map[i][j-1] == map[i][j]) {
                        temp++;
                    } else {
                        temp = 1;
                    }
                }

                if (temp >= M) {
                    happyArr++;
                    break;
                }
            }    
        }

        for (int j=0; j<N; j++) {
            int temp = 0;
            for (int i=0; i<N; i++) {
                if (i == 0) {
                    temp = 1;
                } else {
                    if (map[i-1][j] == map[i][j]) {
                        temp++;
                    } else {
                        temp = 1;
                    }
                }

                if (temp >= M) {
                    happyArr++;
                    break;
                }
            }    
        }

        System.out.print(happyArr);
    }
}