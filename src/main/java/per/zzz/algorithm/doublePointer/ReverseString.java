package per.zzz.algorithm.doublePointer;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/10 11:09
 * 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseString {
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i< words.length; i++){
            res.append(reverseString(words[i].toCharArray())).append(" ");
        }
        return res.toString().substring(0, res.toString().length() - 2);
    }

    public String reverseString(char[] s) {
        for(int i = 0; i < s.length / 2 ; i++){
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        return new String(s);
    }
}
