import java.io.*;
import java.util.*;

public class AddEmUp {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int sum = Integer.parseInt(st.nextToken());
      int index = 0;
      st = new StringTokenizer(br.readLine());
      int[] array = new int[n];
      boolean isEqual = false;
      A: while (st.hasMoreTokens()) {
         array[index++] = Integer.parseInt(st.nextToken());
         B: for (int j = index - 2; j >= 0; j--) {
            if (array[j] == -1) {
               continue;
            }
            if ((array[index - 1] + array[j]) == sum) {
               isEqual = true;
               break A;
            } else {
               int revSum = 0;
               int temp = array[index - 1];
               while (temp > 0) {
                  if (temp % 10 == 3 || temp % 10 == 4 || temp % 10 == 7) {
                     break;
                  }
                  revSum = (revSum * 10) + temp % 10;
                  temp /= 10;
               }
               if ((revSum + array[j]) == sum) {
                  isEqual = true;
                  break B;
               }
               int revSum2 = 0;
               temp = array[j];
               while (temp > 0) {
                  if (temp % 10 == 3 || temp % 10 == 4 || temp % 10 == 7) {
                     array[j] = -1;
                     break;
                  }
                  revSum2 = (revSum2 * 10) + temp % 10;
                  temp /= 10;
               }
               if ((revSum2 + array[index - 1]) == sum || (revSum + revSum2) == sum) {
                  isEqual = true;
                  break A;
               }
            }
         }
      }

      if (isEqual) {
         pw.printf("YES\n");
      } else {
         pw.printf("NO\n");
      }

      pw.flush();
      br.close();
      pw.close();

   }
}