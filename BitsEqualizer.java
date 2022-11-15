import java.util.Scanner;

public class BitsEqualizer {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int numbInput = input.nextInt();
      int counter = 1;
      while (counter <= numbInput) {
         String S = input.next();
         String T = input.next();

         int count10 = 0, count01 = 0, countQmark = 0, totalDiff = 0;
         ;

         for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1' && T.charAt(i) == '0') {
               count10++;
            }
            if (S.charAt(i) == '0' && T.charAt(i) == '1') {
               count01++;
            }
            if (S.charAt(i) == '?' && T.charAt(i) == '1') {
               countQmark++;
            }
            if (S.charAt(i) != T.charAt(i)) {
               totalDiff++;
            }
         }
         if ((count10 - count01 - countQmark) > 0) {
            System.out.printf("Case %d: -1\n", counter);
            counter++;
            continue;
         }

         int min = Math.min(count01, count10);

         System.out.printf("Case %d: %d\n", counter, (totalDiff - min));

         counter++;
      }
      input.close();
   }
}
