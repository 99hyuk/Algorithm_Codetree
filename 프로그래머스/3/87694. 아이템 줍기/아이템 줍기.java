import java.util.*;

class Node {
    int r;
    int c;
    
    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[102][102];
        
        for (int r=0; r<rectangle.length; r++) {
            for (int i=rectangle[r][1]*2; i<=rectangle[r][3]*2; i++) {
                for (int j=rectangle[r][0]*2; j<=rectangle[r][2]*2; j++) {
                    map[i][j] = 2;
                }
            }
        }
        
        for (int r=0; r<rectangle.length; r++) {
            for (int i=rectangle[r][1]*2 + 1; i<rectangle[r][3]*2; i++) {
                for (int j=rectangle[r][0]*2 + 1; j<rectangle[r][2]*2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        // for (int i=0; i<52; i++) {
        //     for (int j=0; j<52; j++) {
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        
        Queue<Node> Q = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];
        
        Q.offer(new Node(characterY*2, characterX*2));
        visited[characterY*2][characterX*2] = true;
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            
            int size = Q.size();
            for (int s=0; s<size; s++) {
                Node node = Q.poll();
            
                if (node.r == itemY*2 && node.c == itemX*2) {
                    return cnt/2;
                }

                for (int d=0; d<4; d++) {
                    int nr = node.r + dr[d];
                    int nc = node.c + dc[d];

                    if (visited[nr][nc]) continue;
                    if (map[nr][nc] != 2) continue;

                    Q.offer(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }

            
            cnt++;
        }
        
        return cnt/2;
    }
}