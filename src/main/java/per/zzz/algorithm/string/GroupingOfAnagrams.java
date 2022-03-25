package per.zzz.algorithm.string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/25 10:56
 *
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class GroupingOfAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] freqT = new char[26];
            for (char c : str.toCharArray()) {
                freqT[c - 'a']++;
            }
            String key = new String(freqT);
            List<String> curList = map.getOrDefault(key, new ArrayList<>());
            curList.add(str);
            map.put(key, curList);
        }
        return new ArrayList<>(map.values());
    }



    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime ={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        List<List<String>> ans = new ArrayList<>();
        Map<BigInteger, Integer> position = new HashMap<>();
        for (String str : strs) {
            BigInteger f = BigInteger.ONE;
            for (int j = 0; j < str.length(); j++) {
                f = f.multiply(BigInteger.valueOf(prime[str.charAt(j) - 'a']));
            }
            if (position.get(f) != null) {
                ans.get(position.get(f)).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                ans.add(newGroup);
                position.put(f, ans.size() - 1);
            }
        }
        return ans;
    }
}
