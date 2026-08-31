import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<Integer> Q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        Q.offer(1);
        visited[1] = true;
        
        int cnt = 0;
        while(!Q.isEmpty()) {
            cnt = Q.size();
            
            int size = Q.size();
            for (int i=0; i<size; i++) {
                Integer num = Q.poll();
                
                for (int next : graph.get(num)) {
                    if(visited[next]) continue;
                    Q.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        return cnt;
    }
}