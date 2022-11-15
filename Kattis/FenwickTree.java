import java.io.*;
import java.util.*;

class FenwickTree {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());

      FenwickTree tree = new FenwickTree(N);

      while (Q-- > 0) {

         st = new StringTokenizer(br.readLine());

         String query = st.nextToken();

         if (query.compareTo("+") == 0) {
            int index = Integer.parseInt(st.nextToken());
            int delta = Integer.parseInt(st.nextToken());

            tree.update(index + 1, delta);
         } else {
            output.println(tree.rsq(Integer.parseInt(st.nextToken())));
         }

      }
      output.flush();
      br.close();
      output.close();
   }

   long[] array;

   public FenwickTree(int size) {
      array = new long[size + 1];
   }

   public long rsq(int ind) {
      assert ind > 0;
      long sum = 0L;

      while (ind > 0) {
         sum += array[ind];
         ind -= ind & (-ind);
      }

      return sum;
   }

   public long rsq(int a, int b) {
      assert b >= a && a > 0 && b > 0;

      return rsq(b) - rsq(a - 1);
   }

   public void update(int ind, int value) {
      assert ind > 0;
      while (ind < array.length) {
         array[ind] += value;
         ind += ind & (-ind);
      }
   }

   public int size() {
      return array.length - 1;
   }
};