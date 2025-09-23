



//This is as close as I got in an hour trying brute foce. It works with substituting forward, but not backwards.
//Ex: XYYX, k=2 -> XXXX = 4. CORRECT
//Ex: AYYX, k=2 -> AAAX = 3. INCORRECT. Correct answer: YYYY = 4.
//But I don't know how yet.
class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        for(int i = 0; i<s.length(); i++){
            int rem = k;
            char startChar = s.charAt(i);
            int length = 1;
            for(int j = i + 1; j<s.length(); j++){
                char c = s.charAt(j);
                if(c != startChar){
                    if(rem == 0){
                        break;
                    }
                    rem--;
                }

                length++;

                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
}