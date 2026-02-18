import java.util.*;
/*
Problem: Eventual Safe States
Concept: DFS + Cycle Detection
Time Complexity: O(V + E)
Space Complexity: O(V)

Explanation:
- Use DFS to detect cycles.
- Nodes that are part of a cycle or lead to a cycle are unsafe.
- Nodes that do not lead to cycles are safe.
*/
public class EventualSafeState {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<Integer> list = new ArrayList<>();
            boolean[] vis= new boolean[n];
            boolean[] pathvis = new boolean[n];
            boolean[] check = new boolean[n];

            for(int i=0;i<n;i++){
                if(!vis[i]){

                    dfs(i,vis,pathvis,check,graph);
                }
            }
            for(int i=0;i<n;i++){
                if(check[i]){
                    list.add(i);
                }
            }
            return list;
        }
        boolean dfs(int i,boolean[] vis,boolean[] pathvis,boolean[] check,int[][] graph){
            vis[i] = true;
            pathvis[i] = true;
            check[i] = false;


            for(int num : graph[i]){
                if(!vis[num]){
                    if(dfs(num, vis, pathvis, check, graph)){
                        return true;
                    }
                }
                else if(pathvis[num]){
                    return true;
                }
            }
            pathvis[i] = false;
            check[i] = true;
            return false;
        }
    }

