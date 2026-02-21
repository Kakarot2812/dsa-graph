import java.util.*;
/*
 * Dijkstra's Algorithm (Using Min-Heap / PriorityQueue)
 *
 * Purpose:
 * Find the shortest distance from a source node to all other nodes
 * in a weighted graph with non-negative edge weights.
 *
 * Approach:
 * - Use a PriorityQueue (min-heap) to always expand the node
 *   with the smallest current known distance.
 * - Maintain a distance array initialized to infinity.
 * - Relax edges using:
 *      dist[v] = min(dist[v], dist[u] + weight)
 * - Skip stale entries using:
 *      if (currentDistance > dist[node]) continue;
 *
 * Time Complexity:
 *      O(E log V)
 *      E = number of edges
 *      V = number of vertices
 *
 * Space Complexity:
 *      O(V)
 *
 * Note:
 * Works only for graphs with non-negative weights.
 */
public class Pair{
    int node;
    int distance;
    Pair(int node,int distance){
        this.node = node;
        this.distance = distance;
    }
}
public class Dijkstra {

    public static int[] dijkstra(int N,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] dis = new int[N];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[S] = 0;
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int distance = curr.distance;
            if (distance > dis[node]) {
                continue;
            }
            for(int i=0;i<adj.get(node).size();i++){
                int neighbour = adj.get(node).get(i).get(0);
                int weight = adj.get(node).get(i).get(1);
                if (weight + distance < dis[neighbour]) {
                    dis[neighbour] = weight + distance;
                    pq.add(new Pair(neighbour,dis[neighbour]));
                }
            }
        }
        return dis;
    }
}
