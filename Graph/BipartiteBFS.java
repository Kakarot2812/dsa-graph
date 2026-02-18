import java.util.*;

/*
   Problem: Check if Graph is Bipartite
   Concept: BFS + Two-coloring
   Time Complexity: O(V + E)
   Space Complexity: O(V)
   */

class BipartiteBFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<color.length;i++){
            if(color[i] == -1){
                if(bfs(i,graph,color) == false){
                    return false;
                }
            }
        }
        return true;
    }
    boolean bfs(int start,int[][] list,int[] color){
        Queue<Integer> queue = new LinkedList<>();
        color[start] = 0;
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int elements : list[node]){
                if(color[elements] == -1){
                    color[elements] = 1 - color[node];
                    queue.add(elements);
                }
                else if(color[elements] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}

