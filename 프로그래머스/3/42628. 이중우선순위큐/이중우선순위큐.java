import java.util.*;

class Solution {
    
    PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b) -> Integer.compare(a, b));
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    Map<Integer, Integer> map = new HashMap<>();
    int size = 0;
   
    public int[] solution(String[] operations) {
        
        for (int i=0; i<operations.length; i++) {
            String[] op = operations[i].split(" ");
            int idx = Integer.parseInt(op[1]);
            
            if (op[0].equals("I")) {
                minQ.offer(idx);
                maxQ.offer(idx);
                size++; 
                
                map.put(idx, map.getOrDefault(idx, 0) + 1);
                
            } else {
                if (size == 0) continue;
                
                if (idx == 1) {
                    clean(maxQ);
                    
                    int num = maxQ.poll();
                        
                    remove(num);
                } else {
                    clean(minQ);
                    
                    int num = minQ.poll();
                    
                    remove(num);
                }
                
                size--;
            }
        }
        
        if (size == 0) {
            return new int[]{0, 0};
        }
        
        clean(minQ);
        clean(maxQ);
        
        int minValue = minQ.peek();
        int maxValue = maxQ.peek();
        
        return new int[]{maxValue, minValue};
    }
    
    void clean(PriorityQueue<Integer> PQ) {
        while (!PQ.isEmpty() && map.getOrDefault(PQ.peek(), 0) == 0) {
            PQ.poll();
        }
    }
    
    void remove(int num) {
        map.put(num, map.get(num)-1);
    }
}