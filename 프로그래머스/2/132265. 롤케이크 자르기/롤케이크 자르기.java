import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        int[] stored1 = new int[1000002];
        int[] stored2 = new int[1000002];
        
        for (int i=0; i<topping.length; i++) {
            set1.add(topping[i]);
            stored1[i] = set1.size();
        }
        
        for (int i=topping.length-1; i>=0; i--) {
            set2.add(topping[i]);
            stored2[i] = set2.size();
        }
        
        int count = 0;
        
        for (int i=0; i<topping.length; i++) {
            if (stored1[i] == stored2[i+1]) count++;
        }
        
        return count;
    }
}