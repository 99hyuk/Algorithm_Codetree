import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] result = new int[prices.length];
        // Arrays.fill(result, prices.length-1);
        
        for (int i=0; i<prices.length; i++) {
            // result[i] -= i;
            int cnt = 0;
            
            for (int j=i+1; j<prices.length; j++) {
                cnt++;
                if (prices[i] > prices[j]) break; 
            }
            
            // result[i] -= cnt;
            result[i] = cnt;
        }
        
        return result;
    }
}