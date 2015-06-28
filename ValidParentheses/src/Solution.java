import java.util.Stack;

/**
 * Created by Mengqi on 15/6/28.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 260 ms
 */
public class Solution {
    public boolean isValid(String s) {
        if(s==null || s.isEmpty())
            return true;

        Stack<Character> parenthesesStack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case ')':
                    if(parenthesesStack.isEmpty() || parenthesesStack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(parenthesesStack.isEmpty() || parenthesesStack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(parenthesesStack.isEmpty() || parenthesesStack.pop() != '{')
                        return false;
                    break;
                case '(':
                case '[':
                case '{':
                    parenthesesStack.push(c);
                    break;
            }
        }
        return parenthesesStack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String teststr = "]";
//        String teststr = "][fea{awr(())}feaw]";
        System.out.println("solution.isValid() = " + solution.isValid(teststr));
    }
}
