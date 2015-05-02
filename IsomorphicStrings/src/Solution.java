import java.util.HashMap;

/**
 * Created by Mengqi on 15/5/2.
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 362 ms
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        //记录已出现的字符，并为每个字符分配一个ID，即该字符第一次出现位置
        HashMap<Character, Integer> charPosS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> charPosT = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            //新出现字符
            if (!charPosS.containsKey(sc)) {
                if (!charPosT.containsKey(tc)) {    //s串新词，则t串也须为新词才同构
                    charPosS.put(sc, i);  //为新出现字符分配ID为i
                    charPosT.put(tc, i);
                } else {
                    return false;
                }
            } else {    //字符已存在
                if (charPosT.containsKey(tc)) {
                    if (charPosS.get(sc) != charPosT.get(tc))
                        return false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "paper", t = "title";
        System.out.println("'"+s+"':'"+t+"'是否同构?\t" + solution.isIsomorphic(s,t));
        s = new String("paper");
        t = new String("white");
        System.out.println("'"+s+"':'"+t+"'是否同构?\t" + solution.isIsomorphic(s,t));
        s = new String("");
        t = new String("s");
        System.out.println("'"+s+"':'"+t+"'是否同构?\t" + solution.isIsomorphic(s,t));
        s = new String("");
        t = new String("");
        System.out.println("'"+s+"':'"+t+"'是否同构?\t" + solution.isIsomorphic(s,t));
        s = new String("s");
        t = new String("t");
        System.out.println("'"+s+"':'"+t+"'是否同构?\t" + solution.isIsomorphic(s,t));

    }
}
