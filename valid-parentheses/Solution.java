
import java.util.HashMap;
import java.util.Stack;

//Time: This is O(n) as we go through the n characters in string s.
//Space: This is O(n) because we need to hold at most n characters in the stack.
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hash = new HashMap<>();
        hash.put('(', ')');
        hash.put('{','}');
        hash.put('[',']');

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i<s.length(); i++)
        {
            char indexChar = s.charAt(i);
            Character matchingChar = hash.get(indexChar);

            if(matchingChar != null){
                stk.push(indexChar);
            }
            else{
                if(stk.isEmpty()){
                    return false;
                }
                Character matchingStkChar = hash.get(stk.pop());
                System.out.println(matchingStkChar);
                if(indexChar != matchingStkChar){
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }
}
