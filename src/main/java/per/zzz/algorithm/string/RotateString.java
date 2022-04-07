package per.zzz.algorithm.string;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/7 9:22
 * 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 */
public class RotateString {
    public static boolean rotateString(String s, String goal) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (stringBuilder.toString().equals(goal)){
                return true;
            }
            stringBuilder.append(s.charAt(i));
            stringBuilder.deleteCharAt(0);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        rotateString(s, goal);
    }
}
