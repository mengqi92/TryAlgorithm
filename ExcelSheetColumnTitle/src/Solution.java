/**
 * Created by Mengqi on 15/2/10.
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class Solution {
    public String convertToTitle(int n) {
        int realnum = n-1;
        if (realnum < 26) {
            return String.valueOf((char) (realnum + 'A'));
        }

        int remainder = realnum % 26;//余数
        int quotient = realnum / 26; //商
        char s = (char) (remainder + 'A');

        String s1 = convertToTitle(quotient);
        return s1+String.valueOf(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(25));
        System.out.println(solution.convertToTitle(26));
        System.out.println(solution.convertToTitle(27));
        System.out.println(solution.convertToTitle(28));
    }
}
