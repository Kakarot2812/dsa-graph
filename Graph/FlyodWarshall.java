import java.util.*;
/*
 * Floyd-Warshall Algorithm
 *
 * Purpose:
 * Computes the shortest distances between all pairs of vertices
 * in a weighted directed graph.
 *
 * Approach:
 * 1. Convert -1 (no edge) to a large value (INF).
 * 2. Set diagonal elements to 0.
 * 3. Use each vertex as an intermediate node (k) and relax paths.
 * 4. Convert unreachable (INF) values back to -1.
 *
 * Time Complexity: O(N^3)
 * Space Complexity: O(1) (in-place modification)
 */
public class FlyodWarshall {
    public static void shortestPath(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
            for(int k=0;k<n;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                            matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                        }
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j] == Integer.MAX_VALUE){
                        matrix[i][j] = -1;
                    }
                }
            }
        }
    }

