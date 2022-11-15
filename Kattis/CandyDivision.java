import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class CandyDivision {

   public static void main(String[] args) throws IOException {

      Reader br = new Reader();
      BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(System.out));

      long n = br.nextLong();
      PriorityQueue<Long> pq = new PriorityQueue<>((int) Math.sqrt(n));

      for (Long i = 1L; i <= Math.sqrt(n); i++) {
         if (n % i == 0) {
            if (n / i == i) {
               pq.add(i - 1);
            } else {
               pq.add(i - 1);
               pq.add((n / i) - 1);

            }
         }
      }

      while (!pq.isEmpty()) {
         pw.write(pq.poll().toString());
         pw.write(' ');
         pw.flush();
      }

      br.close();
      pw.close();

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
         byte[] buf = new byte[64]; // line length
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

class Cat implements Comparable<Cat> {

   private Long arrivalTime;
   private String catName;
   private int infecitonLevel;

   Cat(Long arrivalTime, String catName, int infectionLevel) {
      this.arrivalTime = arrivalTime;
      this.catName = catName;
      this.infecitonLevel = infectionLevel;
   }

   public int getInfecitonLevel() {
      return infecitonLevel;
   }

   public Long getArrivalTime() {
      return this.arrivalTime;
   }

   public String getName() {
      return this.catName;
   }

   public int compareTo(Cat that) {
      if (this.infecitonLevel == that.infecitonLevel) {
         return this.arrivalTime > that.arrivalTime ? 1 : -1;
      } else {
         return this.infecitonLevel < that.infecitonLevel ? 1 : -1;
      }
   }

}
