class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] cache = s.split(" ");

        if(cache.length != pattern.length()){
            return false;
        }

        int [] array = new int[pattern.length()];

        for(int i = 0; i < pattern.length(); i ++){
            for(int j = i + 1; j < pattern.length(); j ++){
                if((pattern.charAt(i) == pattern.charAt(j) && cache[i].compareTo(cache[j]) != 0) || (pattern.charAt(i) != pattern.charAt(j) && cache[i].compareTo(cache[j]) == 0)){
                    return false;
                }
            }
        }
        return true;
    }
}