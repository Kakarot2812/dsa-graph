import java.util.*;

/**
 * LeetCode 207 - Course Schedule
 *
 * Problem:
 * Given total number of courses and prerequisites,
 * determine if it is possible to finish all courses.
 *
 * Approach:
 * - Use Kahn's Algorithm (BFS Topological Sort)
 * - If we can process all nodes → No cycle → return true
 * - If not → Cycle exists → return false
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */

public class courseSchedule1 {
        public boolean canFinish(int numCourse, int[][] prerequisites) {
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
            return i == numCourse;
        }
    }

