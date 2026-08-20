import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            PQ.offer(scoville[i]);
        }
        
        int cnt = 0;
        while (PQ.size() >= 2 && PQ.peek() < K) {
            int food1 = PQ.poll();
            int food2 = PQ.poll();
            
            int newFood = food1 + food2*2;
            
            PQ.offer(newFood);
            cnt++;
        }
        
        if (PQ.peek() < K) cnt = -1;
        
        return cnt;
    }
}