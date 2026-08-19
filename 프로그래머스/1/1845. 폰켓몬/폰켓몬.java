import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        
        if (set.size() >= n/2) {
            return n/2;
        } else {
            return set.size();
        }
    }
}