import java.util.*;

class Solution {

   private int dSum(int n) {
      int sum = 0;
      while (n > 0) {
         sum += (n % 10) * (n % 10);
         n /= 10;
      }

      return sum;
   }

   public boolean isHappy(int n) {
      HashSet<Integer> visited = new HashSet<Integer>();

      while (!visited.contains(n) && n != 1) {

         visited.add(n);
         n = dSum(n);

      }

      if (n != 1) {
         return false;
      }

      return true;
   }
}