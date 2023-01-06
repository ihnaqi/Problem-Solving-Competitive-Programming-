public class Solution {
   public int maxIceCream(int[] costs, int coins) {
      int[] arr = new int[100001];

      for (int i : costs) {
         arr[i]++;
      }

      int count = 0;
      int index = 1;

      while (index < 100001 && coins >= index * arr[index]) {
         coins -= index * arr[index];
         count += arr[index];
         index++;
      }

      while (index < 100001 && coins >= index) {
         coins -= index;
         count++;
      }

      return count;
   }
}
