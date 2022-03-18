package per.zzz.algorithm.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/18 15:28
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    Map<Integer, Integer> cache = new HashMap<>(45);

    // 方法1(动态规划)
    public int climbStairs(int n) {
        int q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            int temp = q;
            q = r;
            r = temp + q;
        }
        return r;
    }

    // 方法2（递归，超时）
    public int climbStairs2(int n) {
        return n == 0 || n == 1 ? 1 : climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    // 方法3（递归缓存表剪枝）
    public int climbStairs3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if(cache.get(n - 1) == null){
            cache.put(n - 1, climbStairs3(n - 1));
        }

        if(cache.get(n - 2) == null){
            cache.put(n - 2, climbStairs3(n - 2));
        }
        return cache.get(n - 1) + cache.get(n - 2);
    }
}
