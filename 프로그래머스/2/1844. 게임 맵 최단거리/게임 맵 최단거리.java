import java.util.*;

class Point {
    int r;
    int c;
    int dist;
    Point(int r, int c, int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

class Solution {
    
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int n, m;
    static int minDist = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        int answer = bfs(maps);
        return answer;
    }
    
    int bfs(int[][] maps) {
        Queue<Point> Q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        Q.offer(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            
            if (p.r == n-1 && p.c == m-1) return p.dist;
            
            for (int dir=0; dir<4; dir++) {
                int nr = p.r + dr[dir];
                int nc = p.c + dc[dir];
                
                if(!isIn(nr,nc)) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;
                
                Q.offer(new Point(nr, nc, p.dist+1));
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    boolean isIn(int r, int c) {
        return 0<=r && r<n && 0<=c && c<m;
    }
}