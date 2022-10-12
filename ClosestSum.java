import java.io.*;
import java.util.PriorityQueue;

public class ClosestSum {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
      String input = "";
      int count = 1;
      while ((input = br.readLine()) != "" && input != null && !input.isEmpty()) {
         pw.printf("Case %d:\n", count);
         int N = Integer.parseInt(input);
         int[] array = new int[N];

         for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
         }

         int[] sumPairs = new int[(N * (N - 1)) / 2];
         int index = 0;
         for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
               sumPairs[index] = array[i] + array[j];
               index++;
            }
         }

         int M = Integer.parseInt(br.readLine());
         int[] queries = new int[M];

         for (int i = 0; i < queries.length; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            PriorityQueue<Duo> pq = new PriorityQueue<>((N * (N - 1)) / 2);
            for (int sum : sumPairs) {
               pq.add(new Duo(sum, queries[i]));
            }

            pw.printf("Closest sum to %d is %d.\n", queries[i], pq.poll().getSum());
         }
         count++;
      }
      pw.flush();
      br.close();
      pw.close();
   }
}

class Duo implements Comparable<Duo> {
   int sum;
   int qurey;

   Duo(int sum, int qurey) {
      this.sum = sum;
      this.qurey = qurey;
   }

   public int getSum() {
      return this.sum;
   }

   @Override
   public int compareTo(Duo that) {
      return Integer.compare(Math.abs(this.sum - this.qurey), Math.abs(that.sum - that.qurey));
   }
}