import java.util.*;

public class Solution {

   private int[] res;

   public int[] countSubTrees(int n, int[][] edges, String labels) {

      res = new int[n];

      ArrayList<Integer>[] a = new ArrayList[n];

      for (int i = 0; i < n; i++) {
         a[i] = new ArrayList<Integer>();
      }

      for (int[] x : edges) {
         a[x[0]].add(x[1]);
         a[x[1]].add(x[0]);
      }

      dfs(-1, 0, a, labels);

      return res;
   }

   private int[] dfs(int prev, int curr, ArrayList<Integer>[] a, String labels) {
      int[] ans = new int[26];

      for (int x : a[curr]) {

         if (prev != x) {
            int[] array = dfs(curr, x, a, labels);

            for (int i = 0; i < array.length; i++) {
               ans[i] += array[i];
            }
         }

      }

      res[curr] = ++ans[labels.charAt(curr) - 'a'];
      return ans;
   }
}