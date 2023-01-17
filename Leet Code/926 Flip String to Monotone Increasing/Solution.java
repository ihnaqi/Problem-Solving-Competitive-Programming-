class Solution {
  public int minFlipsMonoIncr(String s) {

    int res = 0;
    int flips = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        res = Math.min(flips, res + 1);
      } else {
        flips++;
      }
    }
    return res;
  }
}