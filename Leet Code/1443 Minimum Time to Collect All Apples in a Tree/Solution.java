import java.util.*;

public class Solution {
   public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

      List<List<Integer>> adj = new ArrayList<>();

      for (int i = 0; i < n; i++) {
         adj.add(new ArrayList<>());
      }

      for (int[] edge : edges) {
         adj.get(edge[0]).add(edge[1]);
         adj.get(edge[1]).add(edge[0]);
      }

      return solve(0, adj, hasApple, 0);
   }

   private int solve(int index, List<List<Integer>> adj, List<Boolean> hasApple, int source) {
      int res = 0;

      for (int n : adj.get(index)) {
         if (n == source) {
            continue;
         }
         res += solve(n, adj, hasApple, index);
      }

      if (index != 0 && (hasApple.get(index) || res > 0)) {
         res += 2;
      }
      return res;
   }
}