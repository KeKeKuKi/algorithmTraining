package per.zzz.algorithm.other;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/12 18:32
 */
public class PutNumberIn100 {
    public int[] numberOfLines(int[] widths, String s) {
        int count = 0;
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            number += widths[s.charAt(i) - 'a'];
            if (number > 100){
                count ++;
                // 核心在这
                number = widths[s.charAt(i) - 'a'];
            }
        }
        if(number > 0){
            return new int[]{count + 1, number};
        }else {
            return  new int[]{count, 0};
        }
    }
}
