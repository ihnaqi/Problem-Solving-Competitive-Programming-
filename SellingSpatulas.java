import java.io.*;
import java.util.*;

public class SellingSpatulas {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int n;

      while ((n = Integer.parseInt(br.readLine())) != 0) {

         double[] profit = new double[1500];
         Arrays.fill(profit, -0.08);

         for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            double price = Double.parseDouble(st.nextToken());

            profit[time] += price;
         }

         double sum = 0;
         int current_start = 0;
         int current_length = -1;
         double answer = 0;
         int start = Integer.MAX_VALUE;
         int length = Integer.MAX_VALUE;

         for (int i = 0; i < 1500; i++) {
            current_length++;
            sum += profit[i];

            if (sum > answer || (sum == answer && current_length < length)
                  || (sum == answer && current_length == length && current_start < start)) {

               answer = sum;
               length = current_length;
               start = current_start;
            }

            if (sum < 10e-9) {
               sum = 0;
               current_start = i + 1;
               current_length = -1;
            }
         }
         if (answer <= 0) {
            pw.printf("no profit\n");
         } else {
            pw.printf("%.2f %d %d\n", answer, start, start + length);
         }

      }

      pw.flush();
      pw.close();
      br.close();
   }

}
