import java.util.*;

/*
Problem: Surrounded Regions
Platform: LeetCode 130
Concept: DFS from boundary
Difficulty: Medium
Time Complexity: O(m * n)
Space Complexity: O(m * n)
Explanation:
- Start DFS from boundary 'O' cells.
- Mark all reachable 'O' as visited.
- Convert unvisited 'O' cells to 'X'.
*/

public class SurroundedRegion {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] vis = new boolean[m][n];

            for(int i =0;i < m ;i++){
                if(board[i][0] == 'O'){
                    dfs(i,0,board,vis);
                }
                if(board[i][n-1] == 'O'){
                    dfs(i,n-1,board,vis);
                }
            }

            for(int j =0;j < n ;j++){
                if(board[0][j] == 'O'){
                    dfs(0,j,board,vis);
                }
                if(board[m - 1][j] == 'O'){
                    dfs(m - 1,j,board,vis);
                }
            }


            for(int i =0;i < m;i++){
                for(int j =0;j<n;j++){
                    if(board[i][j] == 'O' && vis[i][j] == false){
                        board[i][j] = 'X';
                    }
                }
            }
        }

        void dfs(int row,int col,char[][] board,boolean[][] vis){
            vis[row][col] = true;
            int[] dr = {-1,0,1,0};
            int[] dc =  {0,1,0,-1};

            for(int i =0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && vis[nrow][ncol] == false && board[nrow][ncol] == 'O'){
                    dfs(nrow,ncol,board,vis);
                }
            }
        }
    }

