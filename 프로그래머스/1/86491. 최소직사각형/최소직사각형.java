import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxLen = 0;
        
        for (int i=0; i<sizes.length; i++) {
            maxLen = Math.max(maxLen, Math.max(sizes[i][0], sizes[i][1]));
        }
        
        int height = maxLen;
        int width = 0;

        for (int i=0; i<sizes.length; i++) {
            int minWidth = Math.min(sizes[i][0], sizes[i][1]);
            width = Math.max(minWidth, width);
        }
        
        return height * width;
    }
}