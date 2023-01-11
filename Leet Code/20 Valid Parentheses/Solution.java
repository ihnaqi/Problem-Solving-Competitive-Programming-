import java.util.*;

public class Solution {
   public boolean isValid(String s) {

      Stack<Character> opening = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         switch (c) {
            case '(':
            case '{':
            case '[':
               opening.add(c);
               break;
            case ')':
               if (!opening.isEmpty() && opening.peek() == '(') {
                  opening.pop();
               } else {
                  return false;
               }
               break;
            case ']':
               if (!opening.isEmpty() && opening.peek() == '[') {
                  opening.pop();
               } else {
                  return false;
               }
               break;
            case '}':
               if (!opening.isEmpty() && opening.peek() == '{') {
                  opening.pop();
               } else {
                  return false;
               }
               break;
         }
      }

      return opening.isEmpty();
   }
}