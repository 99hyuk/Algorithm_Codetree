import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for (int i=0; i<results.length; i++) {
            win.get(results[i][0]).add(results[i][1]);
            lose.get(results[i][1]).add(results[i][0]);
        }
        
        int answer = 0;
        
        for (int i=1; i<=n; i++) {
            if(bfs(i, n, win, lose)) {
                // System.out.print(i + " ");   
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean bfs(int idx, int n, List<List<Integer>> win, List<List<Integer>> lose) {
        int cnt = 0;
        
        Queue<Integer> Q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        Q.offer(idx);
        visited[idx] = true;
        
        while(!Q.isEmpty()) {
            int num = Q.poll();
            
            for (int nextWin : win.get(num)) {
                if(visited[nextWin]) continue;
                Q.offer(nextWin);
                visited[nextWin] = true;
            }

            cnt++;
        }
        cnt--;
        
        
        visited = new boolean[n+1];
        Q.offer(idx);
        visited[idx] = true;
        
        while(!Q.isEmpty()) {
            int num = Q.poll();
            
            for (int nextLose : lose.get(num)) {
                if(visited[nextLose]) continue;
                Q.offer(nextLose);
                visited[nextLose] = true;
            }
            
            cnt++;
        }
        cnt--;
        
        
        if (cnt == n-1) return true;
        return false;
    }
}