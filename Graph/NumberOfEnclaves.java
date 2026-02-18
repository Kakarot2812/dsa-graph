import java.util.*;

/*
Problem: Number of Enclaves
Concept: Multi-source BFS from boundary
Time Complexity: O(m * n)
Space Complexity: O(m * n)
*/

public class NumberOfEnclaves {
    class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<Node> queue = new LinkedList<>();
            boolean[][] vis = new boolean[m][n];


            for (int j = 0; j < n; j++) {
                if (grid[0][j] == 1 && !vis[0][j]) {
                    queue.add(new Node(0, j));
                    vis[0][j] = true;
                }
                if (grid[m - 1][j] == 1 && !vis[m - 1][j]) {
                    queue.add(new Node(m - 1, j));
                    vis[m - 1][j] = true;
                }
            }


            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1 && !vis[i][0]) {
                    queue.add(new Node(i, 0));
                    vis[i][0] = true;
                }
                if (grid[i][n - 1] == 1 && !vis[i][n - 1]) {
                    queue.add(new Node(i, n - 1));
                    vis[i][n - 1] = true;
                }
            }

            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            while(!queue.isEmpty()){
                int r = queue.peek().row;
                int c = queue.peek().col;
                queue.remove();

                for(int i=0;i<4;i++){
                    int nrow = r + dr[i];
                    int ncol = c + dc[i];
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
                        queue.add(new Node(nrow,ncol));
                        vis[nrow][ncol] = true;
                    }
                }
            }
            int count = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == 1 && vis[i][j] == false){
                        count++;
                    }
                }
            }
            return count;
        }
    }

