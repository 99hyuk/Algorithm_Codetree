import java.util.*;

class Solution {
    
    int[] sol1 = {1, 2, 3, 4, 5};
    int[] sol2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] sol3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    int len1 = 5;
    int len2 = 8;
    int len3 = 10;
    
    public int[] solution(int[] answers) {
        
        int[] scores = new int[4];
        int pos1 = 0, pos2 = 0, pos3 = 0;
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == sol1[i%len1]) {
                scores[1]++;
            }
            
            if (answers[i] == sol2[i%len2]) {
                scores[2]++;
            }
            
            if (answers[i] == sol3[i%len3]) {
                scores[3]++;
            }
        }
        
        int maxValue = -1;
        for (int i=1; i<4; i++) {
            maxValue = Math.max(maxValue, scores[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<4; i++) {
            if (maxValue == scores[i]) {
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}