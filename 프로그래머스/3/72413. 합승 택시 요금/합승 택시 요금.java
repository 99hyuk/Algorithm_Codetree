import java.util.*;

class Node implements Comparable<Node> {
    int to;
    int dist;
    
    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}

class Solution {
    
    public final int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        List<List<Node>> list = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0; i<fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int dist = fares[i][2];
            
            list.get(from).add(new Node(to, dist));
            list.get(to).add(new Node(from, dist));
        }
        
        int[][] dist = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            PriorityQueue<Node> PQ = new PriorityQueue<>();
            // int[] dist = new int[n+1];
            Arrays.fill(dist[i], INF);

            PQ.offer(new Node(i, 0));
            dist[i][i] = 0;

            while(!PQ.isEmpty()) {
                Node node = PQ.poll();

                int curIdx = node.to;
                int curDist = node.dist;

                if (dist[i][curIdx] < curDist) continue;

                for (Node next : list.get(curIdx)) {
                    int cost = curDist + next.dist;
                    if (cost > dist[i][next.to]) continue;

                    PQ.offer(new Node(next.to, cost));
                    dist[i][next.to] = cost;
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            int sumCost = dist[s][i];
            
            sumCost += dist[i][a] + dist[i][b];
            minCost = Math.min(minCost, sumCost);
        }
        
        return minCost;
    }
}