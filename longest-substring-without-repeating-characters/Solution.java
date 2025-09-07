
import java.util.HashSet;


//MORE IMPROVEMENTS
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<>();
        int l = 0;
        int maxLength = 0;

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            while(hash.contains(c)){
                hash.remove(s.charAt(l));
                l++;
            }

            hash.add(c);
            maxLength = Math.max(hash.size(), maxLength);
            r++;
        }

        return maxLength;
    }
}

//IMPROVEMENTS.
//Same time and space complexity
//We don't need an extra string! Just read from the original with l and r...
//Also only check if we have a bigger string when the character is not in the HashSet. This avoid checking when we have a repeating character,
//and avoid checking when we are done the string (For ex: abc, we would need to check hash.size() > maxLength outside of the loop...)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashSet<Character> hash = new HashSet<>();
//         int l = 0;
//         int r = 0;
//         int maxLength = 0;

//         while(r < s.length()){
//             char c = s.charAt(r);

//             if(!hash.contains(c)){
//                 hash.add(c);
//                 maxLength = Math.max(hash.size(), maxLength);
//             }
//             else{
//                 while(s.charAt(l) != c){
//                     hash.remove(s.charAt(l));
//                     l++;
//                 }
//                 l++;
//             }
//             r++;
//         }

//         return maxLength;
//     }
// }

//Examples used to solve this
//zxyzxyz
//zxyabcy

//Time complexity: O(2n) -> O(n). Since we track the string with a left and right pointer, we read once with right pointer, to expand our window, and then
//read again with the left to shorten the window and clear our array.
//Space complexity: O(n). In the worst case, our string is all unique characters and we need to store all of them in the HashSet.
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashSet<Character> hash = new HashSet<>();
//         String sub = "";
//         int l = 0;
//         int r = 0;
//         int maxLength = 0;

//         while(r < s.length()){
//             char c = s.charAt(r);

//             if(!hash.contains(c)){
//                 hash.add(c);
//             }
//             else{
//                 if(hash.size() > maxLength){
//                     maxLength = hash.size();
//                 }
//                 while(sub.charAt(l) != c){
//                     hash.remove(sub.charAt(l));
//                     l++;
//                 }
//                 l++;
//             }
//             sub += c;
//             r++;
//         }

//         if(hash.size() > maxLength){
//             maxLength = hash.size();
//         }

//         return maxLength;
//     }
// }
