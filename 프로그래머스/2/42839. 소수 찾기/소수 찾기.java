import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0, numbers.length());
        
        int answer = set.size();
        return answer;
    }
    
    public void dfs(String numbers, String result, int idx, int n) {
        if (idx == n) {
            if (result.equals("")) return;
            sosu(Integer.parseInt(result));
            return;
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, result + numbers.charAt(i), idx+1 , n);
            visited[i] = false;
        }
        
        dfs(numbers, result, idx+1 , n);
    }
    
    public void sosu(int num) {
        
        if (num == 0 || num == 1) {
            return;
        }
        
        for (int i=2; i<num; i++) {
            if (num % i == 0) return;
        }
        
        set.add(num);
    }
}