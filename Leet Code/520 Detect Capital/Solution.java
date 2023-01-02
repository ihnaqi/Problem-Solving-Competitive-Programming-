class Solution {

   public boolean detectCapitalUse(String word) {
      boolean allCapital = true;
      boolean allSmall = true;
      boolean firstCapital = true;

      for (int i = 0; i < word.length(); i++) {
         if (word.charAt(i) < 65 || word.charAt(i) > 90) {
            allCapital = false;
            break;
         }
      }

      for (int i = 0; i < word.length() && !allCapital; i++) {
         if (word.charAt('i') < 97 || word.charAt(i) > 122) {
            allSmall = false;
            break;
         }
      }

      for (int i = 0; i < word.length() && !allCapital && !allSmall; i++) {
         if (i == 0) {
            if (word.charAt(i) < 65 || word.charAt(i) > 90) {
               firstCapital = false;
               break;
            }
         } else if (word.charAt('i') < 97 || word.charAt(i) > 122) {
            firstCapital = false;
            break;
         }
      }

      return allCapital || allSmall || firstCapital ? true : false;
   }
}