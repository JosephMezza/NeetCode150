//Time complexity: This is O(n) because we only itterate through the string once with a pointer on
//each side.
//Space complexity: This is O(1) because we only instantiate 2 ints as our left and right pointers.
class Solution {
    public boolean isPalindrome(String s) {
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(j>i && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
