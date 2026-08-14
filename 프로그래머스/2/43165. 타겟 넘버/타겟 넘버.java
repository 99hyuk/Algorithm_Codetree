import java.util.*;

class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {

        dfs(0, numbers.length, numbers, target, 0);
        
        return count;
    }
    
    public void dfs(int idx, int n, int[] numbers, int target, int result) {
        
        if (idx == n) {
            
            if (result == target) count++;
            
            return;
        }
        
        dfs(idx+1, n, numbers, target, result+numbers[idx]);
        dfs(idx+1, n, numbers, target, result-numbers[idx]);
    }
}