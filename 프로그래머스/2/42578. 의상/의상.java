import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        int n = clothes.length;
        
        for (int i=0; i<n; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        
        int answer = 1;
        for (int num : map.values()) {
            answer *= (num+1);
        }
        
        return answer-1;
    }
}