import java.util.*;
/*
   Time Complexity: O(N * L + K)
   Space Complexity: O(K + E)
   */
public class AlienDictionary {
    public static String findorder(String[] dict,int n,int k){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n -1 ;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j)  - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo = topologcial(adj,k);
        StringBuilder result = new StringBuilder();
        for(int neighbour : topo){
            result = result.append((char)(neighbour + 'a'));
        }
        return result.toString();
    }
    private static ArrayList<Integer> topologcial(ArrayList<ArrayList<Integer>> adj,int k){
        ArrayList<Integer> ans = new ArrayList<>();

        int[] inDegree = new int[k];
        for(int i=0;i<k;i++){
            for(int neighbour : adj.get(i)){
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int neighbour : adj.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
        return ans;
    }
}
