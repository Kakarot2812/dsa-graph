import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
 * Performs Topological Sort using Kahn's Algorithm (BFS approach).
 *
 * Time Complexity: O(V + E)
 *  - Computing indegree takes O(E).
 *  - Each vertex is processed once.
 *  - Each edge is relaxed once.
 *
 * Space Complexity: O(V)
 *  - Indegree array takes O(V).
 *  - Queue can store up to O(V) vertices.
 *  - Output array takes O(V).
 *
 * Advantage:
 *  - Can detect cycle:
 *    If number of processed nodes != V,
 *    then graph contains a cycle.
 */

public class TopologicalKahn {
    public static int[] kahn(int n, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[n];
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int i =0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            ans[i] = node;
            i++;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.offer(it);
                }
            }
        }
        if(i != n){
            throw new IllegalStateException("Graph contains a cycle");
        }
        return ans;
    }
}
