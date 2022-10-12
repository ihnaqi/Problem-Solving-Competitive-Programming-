import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ChoppingWood {

   public static void main(String[] args) throws IOException {
      Reader input = new Reader();
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      PriorityQueue<Integer> pq = new PriorityQueue<>();

      int n = input.nextInt();
      int[] vertices = new int[n];
      int[] freq = new int[n + 2];
      ArrayList<Integer> printSequence = new ArrayList<>(n);

      // List of vertices and their frequencies
      for (int i = 0; i < vertices.length; i++) {
         vertices[i] = input.nextInt();
         freq[vertices[i]] += 1;
      }

      // PQ for missing values
      for (int i = 1; i < freq.length; i++) {
         if (freq[i] == 0) {
            pq.add(i);
         }
      }

      for (int i : vertices) {
         try {
            printSequence.add(pq.poll());
            freq[i]--;
         } catch (Exception e) {
            bw.write("Null Pointer");
            bw.write('\n');
            bw.flush();
         }
         if (freq[i] == 0) {
            pq.add(i);
            freq[i]--;
         }
      }

      if (!printSequence.contains(n + 1)) {
         for (int i : printSequence) {
            bw.write(i + "\n");
         }

      } else {
         bw.write("Error\n");
      }
      input.close();
      bw.close();
   }

   static class Reader {
      final private int BUFFER_SIZE = 1 << 16;
      private DataInputStream din;
      private byte[] buffer;
      private int bufferPointer, bytesRead;

      public Reader() {
         din = new DataInputStream(System.in);
         buffer = new byte[BUFFER_SIZE];
         bufferPointer = bytesRead = 0;
      }

      public Reader(String file_name) throws IOException {
         din = new DataInputStream(
               new FileInputStream(file_name));
         buffer = new byte[BUFFER_SIZE];
         bufferPointer = bytesRead = 0;
      }

      public String readLine() throws IOException {
         byte[] buf = new byte[64];
         int cnt = 0, c;
         while ((c = read()) != -1) {
            if (c == '\n') {
               if (cnt != 0) {
                  break;
               } else {
                  continue;
               }
            }
            buf[cnt++] = (byte) c;
         }
         return new String(buf, 0, cnt);
      }

      public int nextInt() throws IOException {
         int ret = 0;
         byte c = read();
         while (c <= ' ') {
            c = read();
         }
         boolean neg = (c == '-');
         if (neg)
            c = read();
         do {
            ret = ret * 10 + c - '0';
         } while ((c = read()) >= '0' && c <= '9');

         if (neg)
            return -ret;
         return ret;
      }

      public long nextLong() throws IOException {
         long ret = 0;
         byte c = read();
         while (c <= ' ')
            c = read();
         boolean neg = (c == '-');
         if (neg)
            c = read();
         do {
            ret = ret * 10 + c - '0';
         } while ((c = read()) >= '0' && c <= '9');
         if (neg)
            return -ret;
         return ret;
      }

      public double nextDouble() throws IOException {
         double ret = 0, div = 1;
         byte c = read();
         while (c <= ' ')
            c = read();
         boolean neg = (c == '-');
         if (neg)
            c = read();

         do {
            ret = ret * 10 + c - '0';
         } while ((c = read()) >= '0' && c <= '9');

         if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
               ret += (c - '0') / (div *= 10);
            }
         }

         if (neg)
            return -ret;
         return ret;
      }

      private void fillBuffer() throws IOException {
         bytesRead = din.read(buffer, bufferPointer = 0,
               BUFFER_SIZE);
         if (bytesRead == -1)
            buffer[0] = -1;
      }

      private byte read() throws IOException {
         if (bufferPointer == bytesRead)
            fillBuffer();
         return buffer[bufferPointer++];
      }

      public void close() throws IOException {
         if (din == null)
            return;
         din.close();
      }
   }

}
