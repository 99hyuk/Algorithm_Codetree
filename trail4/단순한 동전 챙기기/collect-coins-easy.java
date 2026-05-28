import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int num;
    int r;
    int c;
    Node(int num, int r, int c) {
        this.num = num;
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.num, o.num);
    } 
}

public class Main {

    static int n;
    static char[][] map;
    static List<Node> list = new ArrayList<>();
    static Node start;
    static Node end;
    static int minValue = Integer.MAX_VALUE;
    static int size;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        size=0;

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'S') {
                    start = new Node(0,i,j);
                } else if (str.charAt(j) == 'E') {
                    end = new Node(0,i,j);
                } else if (str.charAt(j) >= '1' && str.charAt(j) <= '9') {
                    size++;
                    list.add(new Node(str.charAt(j) - '0', i, j));
                }
            }
        }

        Collections.sort(list);
        visited = new boolean[size];

        if (size < 3) {
            System.out.print(-1);
        } else {
            recursive(0,0);
            System.out.print(minValue);
        }


    }

    static void recursive(int idx, int cnt) {
        if (cnt > 3) {
            return;
        }

        if (idx == size) {
            if (cnt == 3) {
                int dist = 0;

                int curR = start.r;
                int curC = start.c;
                for (int i=0; i<list.size(); i++) {
                    if (visited[i]) {
                        Node node = list.get(i);
                        dist += Math.abs(node.r - curR) + Math.abs(node.c - curC);
                        
                        curR = node.r;
                        curC = node.c;
                    }
                }

                dist += Math.abs(end.r - curR) + Math.abs(end.c - curC);

                minValue = Math.min(minValue, dist);
            }
            return;
        }

        recursive(idx+1, cnt);

        visited[idx] = true;
        recursive(idx+1, cnt+1);
        visited[idx] = false;
    }
}