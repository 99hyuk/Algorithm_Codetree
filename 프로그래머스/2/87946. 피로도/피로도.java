import java.util.*;

class Solution {
    
    int maxValue = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        for (int i=0; i<dungeons.length; i++) {
            if (dungeons[i][0] > k) continue;
            boolean[] visited = new boolean[dungeons.length];
            visited[i] = true;
            dfs(i, k, visited, dungeons, 1);
        }
        
        return maxValue;
        
        
    }
    
    public void dfs(int idx, int Hp, boolean[] visited ,int[][] dungeons, int cnt) {
        
        Hp -= dungeons[idx][1];
        maxValue = Math.max(maxValue, cnt);
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) continue;
            if (Hp < dungeons[i][0]) continue; 
            visited[i] = true;
            dfs(i, Hp, visited, dungeons, cnt+1);
            visited[i] = false;
        }
    }
}