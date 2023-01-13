import java.util.*;

public class Solution {
   int longestPathValue = 1;

   public int longestPath(int[] parent, String s) {

      Map<Integer, List<Integer>> adj = new HashMap<>();
      for (int i = 1; i < parent.length; i++) {
         int j = parent[i];
         adj.putIfAbsent(j, new LinkedList<>());
         adj.get(j).add(i);
      }

      dfs(0, adj, s);
      return longestPathValue;
   }

   public int dfs(int node, Map<Integer, List<Integer>> adj, String s) {

      if (!adj.containsKey(node))
         return 1;
      int max = 0, secondMax = 0;

      for (int nbrNode : adj.get(node)) {
         int longestPathFromNbrNode = dfs(nbrNode, adj, s);

         if (s.charAt(node) == s.charAt(nbrNode))
            continue;

         if (longestPathFromNbrNode > max) {
            secondMax = max;
            max = longestPathFromNbrNode;
         } else if (longestPathFromNbrNode > secondMax) {
            secondMax = longestPathFromNbrNode;
         }
      }

      longestPathValue = Math.max(longestPathValue, max + secondMax + 1);
      return max + 1;
   }
}