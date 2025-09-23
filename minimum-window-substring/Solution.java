
import java.util.HashMap;

//s = "XYZ", t = "XZ" ->"XYZ"

//minLen = 3
//minSub = s.substring(l,r+1) = "XYZ";
//X -> 0
//Z -> 0
//l = 0, r = 2, len = (r-l)+1
//COUNT -> 0

//Last step:
// minLen == Integer.MAX_VALUE -> "";
// else, minSub;


//count = t.length()

//s = "XYZX" t = "XXZ" -> "XYZX" *DUPLICATES MATTER

//s = XABZXAZ, t = "XZ" -> "XAZ"
//s = BAXBXABXA, t = "AAB" -> "ABXA"

//A -> 1
//B -> 0
//COUNT = 1

//minLen = 4
//minSub = AXBXA

//s = A, t = "AB" -> "" s<t

//l, r
//String minSub;
//int minLen = Integer.MAX_VALUE;
//HashMap<Character, Integer>

//Build hashmap

//Time complexity: This runs in O(n + m) time, where n is the length of t and m is the length of s. We need to itterate once over t and at most twice over s. So technically (n + 2m) -> (n+m)
//Space complexity: O(n) because we need to store at most n characters in our hashmap.
//Explanation:
//This solution uses a HashMap<Character, Integer> to keep track of how many times we have seen a character of string t in string s.
//We build a window in s and after every itteration of moving the right pointer of our window, we update our hashmap if we saw a character that we
//are looking for and decrement it's count. Now, to have a valid window, all of the keys in the hashmap need to be at value 0 or less. So on each itteration,
//we check. How do we check? We have a globalCount that keeps track of all of the MEANINGFUL decrements done to our hashmap. Let's say we have t=XY, and in s
//we have "XAXAY", at first when we are building our window we don't decrement globalCount when we read the second X, because we already have
//all the X's we need. The globalCount would have a value of 1 and we are saving it for when we read a Y.
//After the global count reaches 0, now we check: Have we seen a substring this small? If no, then update minLen, minSub to the new values.
//IMPORTANT: We start minLen = Integer.MAX_VALUE so whatever we throw at it first overwrites it.
//So, now within this while loop, we start moving the left pointer to see if we can shrink the window BUT still keep the substring valid.
//Once we move the left pointer to an index, at the end of that itteration we will be kicking it out. Let's say we read a character that is in the hashmap,
//but it's count does not go over 0 when incremented, it means it was an extra and we did not need it in the window, so we have another copy of the character
//in the window to keep it valid.
//We only increment globaCount if the hashmap key's value becomes > 0. So then when the left is moved at the end of the itteration, the window becomes invalid
//and we stop moving left.
//We dont NEED to stop moving left if the next character meets one of these 2 conditions:
//1. It doesn't exist in the hashmap, since the window is already invalid, we know it's gonna be cut later anyways.
//2. It's in the hashmap but it has a NEGATIVE value. We can cut these up until we get the number back to 0 because that means there
//is still an identical character later on that will be potentially used to create a substring. This one has it's chance and since we're
//moving to the right, we will always take the identical character further right.
//I don't DO this in the algo but you can.
//We do this until the right pointer reaches the end of s.
//Then if minLen == MAX_VALUE, we know we didn't find anything so we return "", otherwise return minSub.
//HOW THE WINDOW WORKS:
//Expand right until we hit a valid window (globalCount == 0), and then trim the garbage to the left until we are left
//with the minimum size valid window. And repeat.
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            Integer count = hash.get(c);

            if(count == null){
                hash.put(c, 1);
            }
            else{
                hash.put(c, count+1);
            }
        }

        int minLen = Integer.MAX_VALUE;
        String minSub = "";
        int globalCount = t.length();

        int l = 0;
        for(int r =0; r<s.length(); r++){
            char c = s.charAt(r);

            if(!hash.containsKey(c)){
                continue;
            }

            int count = hash.get(c);

            if(count > 0){
                globalCount--;
            }
            count--;
            hash.put(c, count);

            while(globalCount == 0){
                int len = r-l+1;

                if(len < minLen){
                    minLen = len;
                    minSub = s.substring(l, r+1);
                }

                char lc = s.charAt(l);
                if(!hash.containsKey(lc)){
                    l++;
                    continue;
                }

                int lcount = hash.get(lc);
                lcount++;
                if(lcount > 0){
                    globalCount++;
                }
                hash.put(lc, lcount); //I FORGOT THIS LINE AND GOT STUCK!!
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : minSub;
    }
}
