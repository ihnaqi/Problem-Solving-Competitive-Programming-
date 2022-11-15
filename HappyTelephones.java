import java.io.*;
import java.util.*;

public class HappyTelephones {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException {
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
      while (true) {

         StringTokenizer st = new StringTokenizer(input.readLine()); // 3 2
         int numberOfPhoneCalls = Integer.parseInt(st.nextToken());// 3
         int numberOfIntervals = Integer.parseInt(st.nextToken()); // 2

         if (numberOfIntervals == 0 && numberOfPhoneCalls == 0) {
            break;
         }

         int[][] callsArray = new int[numberOfPhoneCalls][4];
         takeInput(callsArray);

         int[][] intervalsArray = new int[numberOfIntervals][2];
         takeInput(intervalsArray);

         for (int i = 0; i < intervalsArray.length; i++) {
            int count = 0;

            int intervalLength = intervalsArray[i][0] + intervalsArray[i][1];
            for (int row = 0; row < callsArray.length; row++) {

               if (intervalsArray[i][0] < callsArray[row][2] && intervalLength > callsArray[row][2]) {
                  count++;
               } else if (intervalsArray[i][0] >= callsArray[row][2]
                     && intervalsArray[i][0] < (callsArray[row][3] + callsArray[row][2])) {
                  count++;
               }

            }

            pw.printf("%d\n", count);
         }
      }
      input.close();
      pw.close();
   }

   private static void takeInput(int[][] array) throws IOException {
      for (int i = 0; i < array.length; i++) {
         StringTokenizer st = new StringTokenizer(input.readLine());
         int[] arr = new int[st.countTokens()];
         for (int j = 0; j < arr.length; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
         }
         array[i] = arr;
      }
   }
}

/**
 * Logic
 * if ((intervalLength <= callsArray[row][2] + callsArray[row][3] + 1
 * || intervalLength >= callsArray[row][2] - 1)
 * && intervalLength <= (callsArray[row][2] + callsArray[row][3])) {
 * count++;
 * }
 */