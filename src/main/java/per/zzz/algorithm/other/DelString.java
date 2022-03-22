package per.zzz.algorithm.other;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/22 13:51
 */
public class DelString {
    public boolean winnerOfGame(String colors) {
        int sum = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if(colors.charAt(i) == 'A'){
                if(colors.charAt(i-1) == 'A'&& colors.charAt(i + 1) == 'A'){
                    sum ++;
                }
            }
            if(colors.charAt(i) == 'B'){
                if(colors.charAt(i-1) == 'B' && colors.charAt(i + 1) == 'B'){
                    sum --;
                }
            }
        }

        return sum > 0;
    }
}
