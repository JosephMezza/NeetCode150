
import java.util.ArrayList;
import java.util.List;

//Time complexity: Both encode and decode are O(n) where n is total number of characters across all strings.
//Encode is O(n) because to append an entire string, each character is copied by ths string builder. So, we go over ever
//character once.
//Decode is O(n) because we need to itterate through all characters of the combined string to split it back into a list.
//Space complexity: O(1) because we handle all of the 
//Summary:In this approach, we do NOT use
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("@").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j) != '@'){
                j++;
            }
            int strLen = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i + strLen;
            decoded.add(str.substring(i,j));
            i = j;
        }

        return decoded;
    }
}

// class Solution {

//     public String encode(List<String> strs) {
//         if(strs.isEmpty()){
//             return null;
//         }
//         return String.join("é", strs); //O(n) since we have to itterate over all strings
//     }

//     public List<String> decode(String str) {
//         List<String> decoded = new ArrayList<>();

//         if(str == null){
//             return decoded;
//         }

//         int lastDelim = 0;  // Start at the beginning of the string
//     for (int i = 0; i <= str.length(); i++) {
//         // Find delimiter or end of string
//         if(i == str.length()){
//             decoded.add(str.substring(lastDelim, i));
//             break;
//         }
//         if (str.charAt(i) == 'é') {
//             decoded.add(str.substring(lastDelim, i));
//             lastDelim = i + 1;  // Skip past the delimiter for next part
//         }
//     }

//         return decoded;
//     }
// }

