/*
Problem: Breadth-First Search (BFS) Traversal
Concept: Graph traversal using BFS
Difficulty: Easy
Time Complexity: O(V + E) for adjacency list
Space Complexity: O(V) for visited array + queue
Explanation:
- Start BFS from the given node.
- Use a queue to traverse level by level.
- Mark nodes as visited to avoid cycles.
- Print or store nodes in the order they are visited.
*/

import java.util.*;

public class BFS {

    void bfs(int start,int n,List<List<Integer>> adj){

        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        vis[start] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();
            System.out.println(node + " ");

            for(int neighbour : adj.get(node)){
                if(!vis[neighbour]){
                    queue.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }
}
