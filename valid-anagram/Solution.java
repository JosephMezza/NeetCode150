class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] charCount = new int[26];

        for(int i=0; i<s.length(); i++){
            charCount[s.charAt(i)-'a'] += 1;
            charCount[t.charAt(i)-'a'] -= 1;
        }

        for(int num : charCount){
            if(num != 0){
                return false;
            }
        }

        return true;
    }
}
//Time complexity: It is O(n) in this case because we itterate through the length of the
//strings once and +/- at the index the character is mapped to. Then we itterate
//in constant time (26) and check if any index has a value < > to 0.
//Space complexity: This is O(1) because we create an array with 26 indexes.
