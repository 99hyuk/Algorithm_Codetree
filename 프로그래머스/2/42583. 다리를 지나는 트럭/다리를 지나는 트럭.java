import java.util.*;

class Truck {
    int startTime;
    int truck_weight;
    
    Truck (int startTime, int truck_weight) {
        this.startTime = startTime;
        this.truck_weight = truck_weight;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int time = 0;
        int totalWeight = 0;
        int idx = 0;
        
        Queue<Truck> Q = new ArrayDeque<>();
        
        while (idx <= truck_weights.length) {
            
            time++;
            
            if (!Q.isEmpty() && time - Q.peek().startTime >= bridge_length) {
                Truck truck = Q.poll();
                totalWeight -= truck.truck_weight;
            }
            
            if (idx < truck_weights.length && truck_weights[idx] + totalWeight <= weight && Q.size() <= bridge_length) {
                Q.offer(new Truck(time, truck_weights[idx]));
                totalWeight += truck_weights[idx];
                idx++;
            }
            
            if(Q.isEmpty()) break;
        }
        
        return time;
    }
}