import java.util.*;

class Node implements Comparable<Node> {
    int num;
    int requestTime;
    int useTime;
    
    Node (int num, int requestTime, int useTime) {
        this.num = num;
        this.requestTime = requestTime;
        this.useTime = useTime;
    }
    
    @Override
    public int compareTo(Node o) {
        if (this.useTime != o.useTime) {
            return this.useTime - o.useTime;
        } else if (this.requestTime != o.requestTime) {
            return this.requestTime - o.requestTime;
        } else {
            return this.num - o.num;
        }
    }
}

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        List<Node> list = new ArrayList<>();
        
        for (int i=0; i<jobs.length; i++) {
            list.add(new Node(i, jobs[i][0], jobs[i][1]));
        }
        
        list.sort((a, b) -> Integer.compare(a.requestTime, b.requestTime));
        
        int returnTime = 0;
        int time = 0;
        int idx = 0;

        while(idx < jobs.length || !PQ.isEmpty()) {
            
            if (!PQ.isEmpty()) {
                Node node = PQ.poll();
            
                int num = node.num;
                int requestTime = node.requestTime;
                int useTime = node.useTime;

                time += useTime;
                returnTime += (time - requestTime);
            }
            
            while(idx < list.size() && list.get(idx).requestTime <= time) {
                PQ.offer(new Node(list.get(idx).num, list.get(idx).requestTime, list.get(idx).useTime));
                idx++;
            }
            
            if (PQ.isEmpty()) {
                time++;
            }
        }
        
        return returnTime / jobs.length;
    }
}