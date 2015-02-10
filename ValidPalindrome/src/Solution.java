import java.util.regex.Pattern;

/**
 * Created by Mengqi on 15/2/10.
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
//374ms
public class Solution {
    public boolean isPalindrome(String s) {
        //过滤所有非字母字符
        s = s.replaceAll("[^A-Za-z0-9]+", "");
        //针对“ ”、“”情况
        if (s.isEmpty())
            return true;

        boolean palindromeBegin = false;
        for (int i = 0; i < s.length(); i++) {
            //双指针
            int reverse_i = s.length() - 1 - i;

//            if('a' >= s.charAt(i) || s.charAt(i) >= 'z')
//                if('A' >= s.charAt(i) || s.charAt(i) >= 'Z')
//                    i ++;
//            if('a' >= s.charAt(reverse_i) || s.charAt(reverse_i) >= 'z')
//                if('A' >= s.charAt(reverse_i) || s.charAt(reverse_i) >= 'Z')
//                    reverse_i --;

            if (i > reverse_i)
                return palindromeBegin;

            char c = s.charAt(i);
            char rc = s.charAt(reverse_i);
            if (c == rc || Math.abs(c - rc) == Math.abs('A' - 'a')) {
                palindromeBegin = true;
            } else {
                return false;
            }
        }
        return palindromeBegin;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "";
//        String s = "race a car";
//        String s = "a";
//        String s = "abb";
//        String s = "Bab";
        String s = "1a2";
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(s));

    }
}
