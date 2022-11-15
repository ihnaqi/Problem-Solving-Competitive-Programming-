import java.util.Scanner;

public class AlphabetSpam {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      String str = input.nextLine();

      int whiteSpace = 0;
      int upperLetters = 0;
      int lowerLetters = 0;
      int symbols = 0;

      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
            upperLetters++;
         } else if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
            lowerLetters++;
         } else if (str.charAt(i) == 95) {
            whiteSpace++;
         } else {
            symbols++;
         }
      }

      double r1 = (double) whiteSpace / str.length();
      double r2 = (double) lowerLetters / str.length();
      double r3 = (double) upperLetters / str.length();
      double r4 = (double) symbols / str.length();

      System.out.println(r1);
      System.out.println(r2);
      System.out.println(r3);
      System.out.println(r4);
      input.close();
   }
}