import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];        
        int count = 0;
        
        for (int i=0; i<n; i++) {
            if(visited[i]) continue;
            dfs(i, computers, n);
            count++;
        }
        
        int answer = count;
        return answer;
    }
    
    void dfs(int idx, int[][] computers, int n) {
        visited[idx] = true;

        for (int i=0; i<n; i++) {
            if (idx == i) continue;
            if (visited[i]) continue;
            if (computers[idx][i] == 1) {
                dfs(i, computers, n);
            }
        }
    }
}