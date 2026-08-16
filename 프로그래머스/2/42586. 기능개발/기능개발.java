import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] remain = new int[progresses.length];
        
        for (int i=0; i<remain.length; i++) {
            remain[i] = (100 - progresses[i]) / speeds[i];
            
            if ((100 - progresses[i]) % speeds[i] != 0) {
                remain[i]++;
            }
        }
        
        Queue<Integer> Q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<remain.length; i++) {
            Q.offer(remain[i]);
        }
        
        while(!Q.isEmpty()) {
            int cnt = 1;
            int curNum = Q.poll();
            
            while (!Q.isEmpty() && Q.peek() <= curNum) {
                cnt++;
                Q.poll();
            }
            
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}