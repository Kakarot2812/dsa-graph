import java.util.*;
/*
Approach:
- Use BFS to find the shortest path from (0,0) to (n-1,n-1).
- Since movement is allowed in 8 directions, define all 8 possible moves.
- If start or end cell is blocked (1), return -1 immediately.
- Use a queue for level-order traversal.
- Each BFS level represents one path length increment.
- Mark visited cells by converting 0 -> 1 to avoid revisiting.

Time Complexity: O(n^2)
- Each cell is visited at most once.

Space Complexity: O(n^2)
- Queue can store up to n^2 cells in worst case.
*/
public class ShortestPath_BinaryMaze {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        int ans = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];

                if(row == n-1 && col == n-1){
                    return ans;
                }

                for(int[] dir : directions){
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    if(nrow >= 0 && nrow<n && ncol>=0 && ncol<n &&
                            grid[nrow][ncol] == 0){
                        queue.add(new int[]{nrow,ncol});
                        grid[nrow][ncol] = 1;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
