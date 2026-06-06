import java.util.*;

class Solution {
    
    static int minResult = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        dfs(begin, new boolean[words.length], target, words, 0);
        
        if(minResult == Integer.MAX_VALUE) {
            minResult = 0;
        }
        
        return minResult;
    }
    
    public void dfs(String str, boolean[] visited , String target, String[] words, int cnt) {
        
        if (str.equals(target)) {
            minResult = Math.min(minResult, cnt);
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            if (visited[i]) continue;
            
            int idx=0;
            for (int j=0; j<words[i].length(); j++) {
                if (str.charAt(j) != words[i].charAt(j)) idx++;
                if (idx > 1) break;
            }
            
            if (idx == 1) {
                visited[i] = true;
                dfs(words[i], visited, target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
}