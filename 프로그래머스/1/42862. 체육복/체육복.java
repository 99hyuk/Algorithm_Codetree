import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n];
        Arrays.fill(students, 1);
        
        for (int i=0; i<reserve.length; i++) {
            students[reserve[i]-1] = 2;
        }
        
        for (int i=0; i<lost.length; i++) {
            students[lost[i]-1]--;
        }
        
        for (int i=0; i<n; i++) {
            if (students[i] < 2) continue;
            
            if (i-1 >= 0 && students[i-1] == 0) {
                students[i-1]++;
                students[i]--;
                continue;
            } else if (i+1 < students.length && students[i+1] == 0) {
                students[i+1]++;
                students[i]--;
                continue;
            }
        }
        
        int answer = 0;
        for (int i=0; i<students.length; i++) {
            if (students[i] >= 1) answer++;
        }
            
        return answer;
    }
}