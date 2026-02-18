import java.util.*;

/*
Problem: Number of Distinct Islands
Concept: DFS + Relative Coordinate Hashing
Time Complexity: O(n * m)
Space Complexity: O(n * m)

Explanation:
- Traverse the grid and start DFS whenever an unvisited land cell (1) is found.
- For each island, store the relative position of every cell
  with respect to the starting cell of that island.
- Store the shape of each island as a list of relative coordinates.
- Add this list to a HashSet to keep only unique island shapes.
- The size of the HashSet represents the number of distinct islands.
*/

public class NumberOfDistinctIsland {
    public static int countDistinctIsland(int [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,list,vis,grid,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    private static void dfs(int row,int col,ArrayList<String> list,boolean[][] vis,int[][] grid,int row0,int col0){

        vis[row][col] = true;
        list.add(tostring(row - row0,col - col0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && !vis[nrow][ncol] &&
                    grid[nrow][ncol] == 1){
                dfs(nrow,ncol,list,vis,grid,row0,col0);
            }
        }
    }
    private static String tostring(int row,int col){
        return Integer.toString(row) + " " + Integer.toString(col);
    }
}
