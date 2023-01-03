import java.util.*;

class Solution {
   public boolean canConstruct(String ransomNote, String magazine) {
      Map<Character, Integer> magazineMap = new HashMap<>();

      for (int i = 0; i < magazine.length(); i++) {
         magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
      }

      for (int i = 0; i < ransomNote.length(); i++) {
         if (magazineMap.getOrDefault(ransomNote.charAt(i), 0) == 0) {
            return false;
         }
         magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i)) - 1);
      }
      return true;
   }
}