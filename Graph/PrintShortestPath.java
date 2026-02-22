import java.util.*;
/*
 * Problem: Print Shortest Path in a Weighted Undirected Graph
 *
 * Approach:
 * - Use Dijkstra’s Algorithm with a Min-Heap (PriorityQueue).
 * - Build adjacency list for undirected graph.
 * - Maintain:
 *      dis[]    -> shortest distance from source (node 1)
 *      parent[] -> to reconstruct the shortest path
 *
 * Steps:
 * 1. Initialize distances to infinity.
 * 2. Set source distance to 0.
 * 3. Use PriorityQueue to always expand the node with minimum distance.
 * 4. Relax edges:
 *      If dis[node] + weight < dis[neighbour]
 *          update distance
 *          update parent
 *          push into PQ
 * 5. Use stale-entry check to skip outdated PQ entries.
 * 6. Reconstruct path from N back to 1 using parent array.
 *
 * Time Complexity:
 *      O((V + E) log V)
 *
 * Space Complexity:
 *      O(V + E)
 *
 * Notes:
 * - Uses Comparable implementation for cleaner PQ handling.
 * - Returns [-1] if destination is unreachable.
 */
class NodeDistance implements Comparable<NodeDistance> {
    int node;
    int distance;

    public NodeDistance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(NodeDistance other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class PrintShortestPath {
    public static List<Integer> shortestPath(int N,int M,int[][] edges){
        ArrayList<ArrayList<NodeDistance>> adj = new ArrayList<>();
        for(int i=0;i<=N;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            adj.get(edges[i][0]).add(new NodeDistance(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new NodeDistance(edges[i][0],edges[i][2]));
        }

        int[] dis = new int[N+1];
        int[] parent = new int[N+1];
        for(int i=1;i<=N;i++){
            dis[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dis[1] = 0;

        PriorityQueue<NodeDistance> pq = new PriorityQueue<>();
        pq.add(new NodeDistance(1,0));

        while(!pq.isEmpty()){
            NodeDistance adjNode = pq.poll();
            int node = adjNode.node;
            int distance = adjNode.distance;
            if(distance > dis[node]) continue;

            for(NodeDistance it : adj.get(node)){
                int neighbour = it.node;
                int weight = it.distance;
                if(distance + weight < dis[neighbour]){
                    dis[neighbour] = distance + weight;
                    pq.add(new NodeDistance(neighbour,dis[neighbour]));
                    parent[neighbour] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dis[N] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node = N;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
