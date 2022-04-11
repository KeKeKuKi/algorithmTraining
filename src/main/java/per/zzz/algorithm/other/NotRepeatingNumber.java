package per.zzz.algorithm.other;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/11 18:41
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 */
public class NotRepeatingNumber {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 9, ans = 9;
        for (int i = 2; i <= n; i++) {
            count *= (11 - i);
            ans += count;
        }
        return 1 + ans;
    }
}
