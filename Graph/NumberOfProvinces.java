/*
Problem: Number of Provinces
Platform: LeetCode 547
Concept: DFS (Graph traversal)
Difficulty: Medium
Time Complexity: O(n^2)
Space Complexity: O(n) for visited array (recursion stack)
Explanation:
- Iterate through each city.
- If not visited, start DFS and mark all connected cities as visited.
- Each DFS traversal corresponds to one province.
*/


    public class NumberOfProvinces {
        public int findCircleNum(int[][] isConnected) {
            int m = isConnected.length;
            boolean[] vis = new boolean[m];
            int count = 0;
            for(int i =0;i< m;i++){
                if(vis[i] == false){
                    count++;
                    dfs(i,vis,isConnected);
                }
            }
            return count;
        }
        void dfs(int city,boolean[] vis,int[][] arr){
            vis[city] = true;


            for(int i =0;i < arr.length;i++){

                if(vis[i] == false && arr[city][i] == 1){
                    dfs(i,vis,arr);
                }
            }
        }
    }

