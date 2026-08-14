import java.util.*;

class Solution {
    
    int count = 0;
    int ans = 0;
    
    public int solution(String word) {
        
        dfs(0, "", word);
        
        return ans;
    }
    
    public void dfs(int idx, String result, String word) {
        
        if (!result.equals("")) {
            count++;
        }
        
        if(result.equals(word)) {
                ans = count;
            }
            
        if (idx == 5) {
            return;
        }
        
        dfs(idx+1, result + "A", word);
        dfs(idx+1, result + "E", word);
        dfs(idx+1, result + "I", word);
        dfs(idx+1, result + "O", word);
        dfs(idx+1, result + "U", word);
    }
}