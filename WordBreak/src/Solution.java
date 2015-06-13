import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mengqi on 15/6/14.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 * 260ms
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.isEmpty()) return false;
        if(wordDict==null || wordDict.isEmpty()) return false;
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        for(int endPos = 0; endPos < s.length()+1; endPos++) {
            // breakable[s.length]==true 时可不必再迭代计算
            for(int startPos = endPos-1; startPos >= 0 && !breakable[s.length()]; startPos--) {
                if(wordDict.contains(s.substring(startPos, endPos)) && breakable[startPos])
                    breakable[endPos] = true;
            }
        }
        return breakable[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak("l", wordDict));
    }
}
