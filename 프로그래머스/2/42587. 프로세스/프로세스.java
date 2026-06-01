import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int prior;
    Node (int idx, int prior) {
        this.idx = idx;
        this.prior = prior;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.prior, this.prior);
    }
}

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Node> Q = new ArrayDeque<>();
        for (int i=0; i<priorities.length; i++) {
            Q.offer(new Node(i, priorities[i]));
        }
        
        int order = 0;
        int answer = 0;
        for (int i=9; i>=1; i--) {
            while (true) {
                boolean check = false;
                for (int j=0; j<Q.size(); j++) {
                    Node node = Q.poll();
                    if (node.prior == i) check = true;
                    Q.offer(node);
                }
                
                if(!check) break;
                
                Node node = Q.poll();
                
                if (node.prior == i) {
                    order++;
                    if (node.idx == location) {
                        answer = order;
                        break;
                    }
                } else {
                    Q.offer(node);
                }
            }
        }

        
        return answer;
    }
}