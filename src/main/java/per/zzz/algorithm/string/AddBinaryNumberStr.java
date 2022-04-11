package per.zzz.algorithm.string;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/11 19:58
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class AddBinaryNumberStr {

    public static String addBinary(String a, String b) {
        if(a.length() > b.length()){
            b = getZeroStr(a.length() - b.length()) + b;
        }else {
            a = getZeroStr(b.length() - a.length()) + a;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int step = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int add = (a.charAt(i) - '0') + (b.charAt(i) - '0') + step;
            stringBuilder.insert(0, add == 2 || add == 0  ? 0 : 1);
            step = add > 1  ? 1 : 0;
        }

        if (step > 0){
            return "1" + stringBuilder;
        }
        return stringBuilder.toString();
    }

    public static String getZeroStr(int len){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append('0');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        addBinary(a,b);

    }
}
