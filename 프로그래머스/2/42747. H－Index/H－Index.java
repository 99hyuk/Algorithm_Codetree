import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int h = 0;
        
        while(HIndex(n, h, citations)) {
            h++;
        }
        
        h--;
        if (h<0) h=0;
        
        return h;
    }
    
    public boolean HIndex(int n, int h, int[] citations) {
        
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (citations[i] >= h) cnt++;
        }
        
        if (cnt >= h) return true;
        return false;
    }
}