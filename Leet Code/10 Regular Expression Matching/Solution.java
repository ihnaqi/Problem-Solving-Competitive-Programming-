class Solution {
   public boolean isMatch(String s, String p) {

      if (p == null || p.length() == 0) {
         return (s == null || s.length() == 0);
      }
      boolean cache[][] = new boolean[s.length() + 1][p.length() + 1];
      cache[0][0] = true;
      for (int col = 2; col <= p.length(); col++) {
         cache[0][col] = p.charAt(col - 1) == '*' && cache[0][col - 2];
      }

      for (int col = 1; col <= p.length(); col++) {
         for (int row = 1; row <= s.length(); row++) {
            if (p.charAt(col - 1) == s.charAt(row - 1) || p.charAt(col - 1) == '.') {
               cache[row][col] = cache[row - 1][col - 1];
            } else if (p.charAt(col - 1) == '*') {
               cache[row][col] = cache[row][col - 2]
                     || ((s.charAt(row - 1) == p.charAt(col - 2) || p.charAt(col - 2) == '.') && cache[row - 1][col]);
            }
         }
      }

      return cache[s.length()][p.length()];
   }
}