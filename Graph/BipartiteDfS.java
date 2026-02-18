import java.util.*;
public class BipartiteDfS {


    /*
    Problem: Check if Graph is Bipartite
    Concept: DFS + Two-coloring
    Time Complexity: O(V + E)
    Space Complexity: O(V)
    */

    public static boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!dfs(i,graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfs(int start,int[][] graph,int[] color){
        for(int adj : graph[start]){
            if(color[adj] == -1) {
                color[adj] = 1 - color[start];
                if (!dfs(adj, graph, color)) {
                    return false;
                }
            }
            else if(color[adj] == color[start]){
                return false;
            }
        }
        return true;
    }
}
