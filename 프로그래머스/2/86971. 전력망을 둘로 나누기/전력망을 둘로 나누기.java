import java.util.*;

class Solution {
    
    int minValue = Integer.MAX_VALUE;
    int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        
        for (int i=0; i<wires.length; i++) {
            cnt = 0;
            boolean[] visited = new boolean[n+1];
            
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            
            wires[i][0] = 0;
            wires[i][1] = 0;
            dfs(1, visited, wires);
            wires[i][0] = node1;
            wires[i][1] = node2;
            
            minValue = Math.min(minValue,Math.abs(cnt - (n-cnt)));
        }
        
        return minValue;
    }
    
    public void dfs(int idx, boolean[] visited, int[][] wires) {
        cnt++;
        visited[idx] = true;
        
        for (int[] arr : wires) {
            if (arr[0] == idx && !visited[arr[1]]) {
                dfs(arr[1], visited, wires);
            } else if (arr[1] == idx && !visited[arr[0]]) {
                dfs(arr[0], visited, wires);
            }
        }
    }
}