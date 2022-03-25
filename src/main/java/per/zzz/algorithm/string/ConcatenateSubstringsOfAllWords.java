package per.zzz.algorithm.string;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/25 13:16
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 */
public class ConcatenateSubstringsOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int step = words[0].length() * words.length;
        for (int i = 0; i < s.length() - step + 1; i++) {
            int j = i + step;
            String substring = s.substring(i, j);

            for (int k = 0; k < words.length; k++) {
                if (!substring.contains(words[k])){
                    break;
                }
                substring = substring.replaceFirst(words[k], "%%%%%");
                if (k == words.length - 1){
                    ans.add(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};

        findSubstring(s, words);
    }
}
