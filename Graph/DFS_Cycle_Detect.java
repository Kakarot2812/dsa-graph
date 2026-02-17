import java.util.ArrayList;

/*
Problem: Detect Cycle in Undirected Graph
Concept: DFS
Difficulty: Medium
Time Complexity: O(V + E)
Space Complexity: O(V) for visited + recursion stack
Explanation:
- Traverse each component of the graph.
- Use DFS and track parent of each node.
- If a visited neighbor is found that is not the parent,
  then a cycle exists.
*/

public class DFS_Cycle_Detect {
    public static boolean isCycleDFS(int n, ArrayList<ArrayList<Integer>> adj){

        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
               if( checkForCycle(i,-1,vis,adj)){
                   return true;
               }
            }
        }
        return false;
    }
    private static boolean checkForCycle(int node,int parent,boolean[] vis,ArrayList<ArrayList<Integer>> adj){

        vis[node] = true;

        for(int adjacentNode : adj.get(node) ){
            if(!vis[adjacentNode]) {
                if (checkForCycle(adjacentNode, node, vis, adj)) {
                    return true;
                }
            }
            else if (adjacentNode != parent) {
                return true;
            }
        }
        return false;
    }
}
