class DisjointSet {
   int[] parent, size;

   public DisjointSet(int n) {
      parent = new int[n + 1];
      size = new int[n + 1];
      for (int i = 0; i <= n; i++) {
         parent[i] = i;
         size[i] = 1;
      }
   }

   int findPar(int node) {
      if (node == parent[node])
         return node;
      return parent[node] = findPar(parent[node]);
   }

   void unionBySize(int u, int v) {
      int up = findPar(u);
      int uv = findPar(v);
      if (up == uv)
         return;
      if (up < uv) {
         parent[uv] = up;
      } else {
         parent[up] = uv;
      }
   }
}

public class Solution {
   public String smallestEquivalentString(String s1, String s2, String baseStr) {
      int n = s1.length();
      DisjointSet ds = new DisjointSet(26);
      for (int i = 0; i < n; i++) {
         ds.unionBySize(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
      }
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < baseStr.length(); i++) {
         res.append((char) (ds.findPar(baseStr.charAt(i) - 'a') + 'a'));
      }
      return res.toString();
   }
}