package per.zzz.algorithm.depthFirst;

import java.math.BigInteger;
import java.util.*;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/11 19:16
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class AllMaybeString {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1){
            return new ArrayList<>();
        }

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<List<Character>> all = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            all.add(map.get(digits.charAt(i)));
        }
        dfs(all, 0, "");
        return ans;
    }

    public void dfs(List<List<Character>> all, int deep, String temp){
        if(deep == all.size()){
            ans.add(temp);
            return;
        }
        for (int i = 0; i < all.get(deep).size(); i++) {
            dfs(all, deep + 1, temp + all.get(deep).get(i));
        }
    }
}
