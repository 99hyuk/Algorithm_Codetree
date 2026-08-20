import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long low = 0;
        long high = 1_000_000_000_000_000_000L;
            
        while(low <= high) {
            long mid = (low + high) / 2;
            
            if (exit(n, times, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    public boolean exit(int n, int[] times, long mid) {
        long sumPeople = 0;
        
        for (int i=0; i<times.length; i++) {
            sumPeople += mid / times[i];
        }
        
        if (sumPeople >= n) return true;
        return false;
    }
}