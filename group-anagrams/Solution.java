
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// public class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         String[] sortedCopy = new String[strs.length];
//         HashMap<String, List<String>> hashMap = new HashMap<>();

//         for(String s: strs){
//             char[] sortedArr = s.toCharArray();
//             Arrays.sort(sortedArr);
//             String sortedString = new String(sortedArr);

//             hashMap.putIfAbsent(sortedString, new ArrayList<>());
//             hashMap.get(sortedString).add(s);
//         }

//         return new ArrayList<>(hashMap.values());
//     }
// }
//Time complexity: Time complexity of this is O(n*m*log(m)). This can be improved..
//Space complexity: Finally I understand, in this solution it is O(n*m). If we look at the map, the VALUE is being passed by reference from the original array of strings. BUT! The KEY is what requires memory. We need to create a NEW String for each key because
//it is sorted. So, in the worst case, every string in the array needs it's own key and if each string is in worst case the size of the largest, this will require O(n*m) memory! n being the number of strings, and m being the number of characters in the largest string.


//For this problem, we will track the anagrams as a list of strings in a hashmap as values. For the key, we will be tracking the count of each character in an array of int[] of size 26. Then we'll transform this into a string and use it as the key. All
//anagrams will have this same key!
//Time complexity: It will be O(n*m) since we are itterating over n strings, and for each we are itterating over m characters. Then we itterate of a maximum of n keys in the hashmap but we drop this since n*m is bigger.
//Space complexity: It will be O(n) becuase we need to create space in our hashmap to store n keys. The keys are all of size 26 but it will require
//n keys, where n is the number of strings.
public class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] charCount = new int[26];

            for(char c : strs[i].toCharArray()){
                charCount[c-'a'] += 1;
            }
            String key = Arrays.toString(charCount);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}