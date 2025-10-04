
import java.util.HashMap;

//Time complexity: O(2n) -> O(n) pass each character once for it to enter the window, and to leave the window.
//Space complexity: O(m), where m is the total number of unique characters in s. But it is really O(1), because there can 
//be a maximum of 26 characters.
//Explanation: We build a sliding window that will grow until we hit an invalid window size. While the window is growing,
//during each itteration, we update the maxFreq so we know what is the character with the maximum frequency we have seen so far.
//We also increment the count in the hash map on how many times we've seen that character to then check if it becomes the new
//maxFreq.
//We then use the maxFrequency to see if our window is still valid. So, if the window is still valid with our maxFreq,
//then no need to shrink it because the window size including the most frequent character inside still works.
//We then recompute our max Window size and increase our window by 1.
//If ever we increase by 1 and then the window is invalid, we start cutting characters from the left and updating the hashmap.
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hash = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxWindow = 0;
        int maxFreq = 0;

        while(r < s.length()){
            char charR = s.charAt(r);
            Integer countR = hash.getOrDefault(charR, 0) + 1;
            hash.put(charR, countR);

            maxFreq = Math.max(maxFreq, countR);

            while(r-l+1 - maxFreq > k){
                Integer countL = hash.get(s.charAt(l));
                countL--;
                hash.put(s.charAt(l), countL);
                l++;
            }

            int window = r-l+1;
            maxWindow = Math.max(maxWindow, window);
            r++;
        }

        return maxWindow;
    }
}

//This is as close as I got in an hour trying brute foce. It works with substituting forward, but not backwards.
//Ex: XYYX, k=2 -> XXXX = 4. CORRECT
//Ex: AYYX, k=2 -> AAAX = 3. INCORRECT. Correct answer: YYYY = 4.
//But I don't know how yet.
// class Solution {
//     public int characterReplacement(String s, int k) {
//         int maxLength = 0;
//         for(int i = 0; i<s.length(); i++){
//             int rem = k;
//             char startChar = s.charAt(i);
//             int length = 1;
//             for(int j = i + 1; j<s.length(); j++){
//                 char c = s.charAt(j);
//                 if(c != startChar){
//                     if(rem == 0){
//                         break;
//                     }
//                     rem--;
//                 }

//                 length++;

//                 maxLength = Math.max(length, maxLength);
//             }
//         }

//         return maxLength;
//     }
// }