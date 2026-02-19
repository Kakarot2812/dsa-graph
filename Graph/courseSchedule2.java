import java.util.*;

/**
 * LeetCode 210 - Course Schedule II
 *
 * Problem:
 * Return the order of courses you should take to finish all courses.
 * If impossible (cycle exists), return an empty array.
 *
 * Approach:
 * - Kahn's Algorithm (BFS Topological Sort)
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */

public class courseSchedule2 {
        public int[] findOrder(int numCourse, int[][] prerequisites) {
            List<List<Integer>> adj = new ArrayList<>();
            int[] ans = new int[numCourse];
            int[] inDegree = new int[numCourse];
            Queue<Integer> queue = new LinkedList<>();

            for(int i=0;i<numCourse;i++){
                adj.add(new ArrayList<>());
            }

            for(int i=0;i<prerequisites.length;i++){
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            for(int i=0;i<numCourse;i++){
                for(int num : adj.get(i)){
                    inDegree[num]++;
                }
            }

            for(int i=0;i<numCourse;i++){
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }

            int i= 0;
            while(!queue.isEmpty()){
                int node = queue.poll();
                ans[i] = node;
                i++;
                for(int num : adj.get(node)){
                    inDegree[num]--;
                    if(inDegree[num] == 0){
                        queue.add(num);
                    }
                }
            }
            if(i == numCourse){
                return ans;
            }
            return new int[0];
        }
    }

