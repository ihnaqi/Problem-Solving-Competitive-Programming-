import java.util.*;

public class Solution {
   public int getKth(int lo, int hi, int k) {

      PriorityQueue<Pair> pq = new PriorityQueue<>();

      for (int num = lo; num <= hi; num++) {

         int n = num;
         int steps = 0;

         while (n > 1) {
            steps++;

            if ((n & 1) == 1) {
               n = (n * 3) + 1;
            }

            else {
               n >>= 1;
            }
         }

         pq.add(new Pair(num, steps));

      }

      while (k-- > 1) {
         pq.poll();
      }

      return pq.poll().getNum();
   }
}

class Pair implements Comparable<Pair> {
   private int num;
   private int pow;

   Pair(int n, int p) {
      this.num = n;
      this.pow = p;
   }

   @Override
   public int compareTo(Pair that) {
      if (this.getPow() == that.getPow()) {
         return this.getNum() < that.getNum() ? 1 : -1;
      }
      return this.getPow() < that.getPow() ? 1 : -1;
   }

   public int getPow() {
      return this.pow;
   }

   public int getNum() {
      return this.num;
   }

}