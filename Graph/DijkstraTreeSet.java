import java.util.*;
/*
 * Dijkstra's Algorithm using TreeSet
 *
 * Approach:
 * - Use TreeSet to always extract the node with minimum distance
 * - Remove old (node, distance) pairs before inserting updated ones
 * - Avoids stale entries present in PriorityQueue approach
 *
 * Time Complexity: O(E log V)
 * Space Complexity: O(V)
 *
 * Works only for non-negative edge weights.
 */

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class DijkstraTreeSet {

    public static int[] dijkstra(
            int N,
            ArrayList<ArrayList<ArrayList<Integer>>> adj,
            int S) {

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        TreeSet<Pair> set = new TreeSet<>(
                (a, b) -> a.distance != b.distance
                        ? a.distance - b.distance
                        : a.node - b.node
        );

        set.add(new Pair(S, 0));

        while (!set.isEmpty()) {

            Pair curr = set.pollFirst();
            int node = curr.node;
            int distance = curr.distance;

            for (int i = 0; i < adj.get(node).size(); i++) {

                int neighbour = adj.get(node).get(i).get(0);
                int weight = adj.get(node).get(i).get(1);

                if (distance + weight < dist[neighbour]) {

                    // Remove old entry if present
                    if (dist[neighbour] != Integer.MAX_VALUE) {
                        set.remove(new Pair(neighbour, dist[neighbour]));
                    }

                    dist[neighbour] = distance + weight;
                    set.add(new Pair(neighbour, dist[neighbour]));
                }
            }
        }
        return dist;
    }
}
