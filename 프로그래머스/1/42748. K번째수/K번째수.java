import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for (int o=0; o<commands.length; o++) {
            List<Integer> list = new ArrayList();
            
            int i = commands[o][0];
            int j = commands[o][1];
            int k = commands[o][2];
            
            for (int p=i-1; p<j; p++) {
                list.add(array[p]);
            }
            
            Collections.sort(list);
            
            answer[o] = list.get(k-1);
        }
        
        return answer;
    }
}