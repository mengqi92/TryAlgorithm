import java.util.ArrayList;
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
 429 ms
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        ArrayList<Integer> PosListS = getStringStructure(s);
        ArrayList<Integer> PosListT = getStringStructure(t);


        return PosListS.equals(PosListT);
    }

    public ArrayList<Integer> getStringStructure(String string) {
        //存放字符串的结构，每个元素为字符对应的ID值
        ArrayList<Integer> PosList = new ArrayList<Integer>();
        //记录已出现的字符，并为每个字符分配一个ID，即该字符第一次出现位置
        HashMap<Character, Integer> charPosS = new HashMap<Character, Integer>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            //新出现字符
            if (!charPosS.containsKey(c)) {
                charPosS.put(c, i);  //为新出现字符分配ID为i
                PosList.add(i);    //将新分配ID存入字符串结构中
            } else {    //字符已存在
                PosList.add(charPosS.get(c));
            }
        }
//
//        System.out.println("string = " + string);
//        for (int i = 0; i < PosList.size(); i++) {
//            System.out.print(PosList.get(i) + ",");
//        }
//        System.out.println();
        return PosList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("是否同构?" + solution.isIsomorphic("paper", "title"));
    }
}
