import java.util.*;

class Solution {
   public int minimumRounds(int[] tasks) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int i : tasks) {
         map.put(i, map.getOrDefault(i, 0) + 1);
      }

      int round = 0;

      for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
         int n = pair.getValue();

         while (n > 1) {
            if (n > 4 || n == 3) {
               n = n - 3;
            } else {
               n = n - 2;
            }
            round++;
         }

         if (n == 1) {
            return -1;
         }
      }

      return round;

   }

}