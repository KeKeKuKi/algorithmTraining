package per.zzz.algorithm.string;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/7 9:44
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class longestPrefixStr {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || strs[j].charAt(i) != c){
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
