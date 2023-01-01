import java.io.*;
import java.util.StringTokenizer;

public class App {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] nums = new int[st.countTokens()];

      while (st.hasMoreTokens()) {
         nums[nums.length - st.countTokens()] = Integer.parseInt(st.nextToken());
      }

      long[] aStartSum = new long[nums.length];
      long[] aEndSum = new long[nums.length];

      aStartSum[0] = nums[0];
      aEndSum[nums.length - 1] = nums[nums.length - 1];

      for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
         aStartSum[i] = aStartSum[i - 1] + nums[i];
         aEndSum[j] = aEndSum[j + 1] + nums[j];
      }

      long min = Long.MAX_VALUE;
      int index = -1;

      for (int i = 0; i < aStartSum.length; i++) {

         if (aStartSum.length - i - 1 == 0) {

            if (Math.floor(Math.abs(aStartSum[i] / (i + 1))) < min) {
               index = i;
            }
            break;
         }

         if (Math.abs(Math.floor(aStartSum[i] / (i + 1)) - Math.floor(aEndSum[i + 1] / (nums.length - i - 1))) < min) {
            index = i;
            min = (long) Math
                  .abs(Math.floor(aStartSum[i] / (i + 1)) - Math.floor(aEndSum[i + 1] / (nums.length - i - 1)));
         }
      }

      pw.printf("%d\n", min == Long.MAX_VALUE ? 0 : index);

      br.close();
      pw.flush();
      pw.close();
   }

}
