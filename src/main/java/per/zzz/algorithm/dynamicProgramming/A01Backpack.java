package per.zzz.algorithm.dynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/7 18:56
 * DP41 【模板】01背包
 * 中等  通过率：44.95%  时间限制：1秒  空间限制：256M
 * 描述
 * 你有一个背包，最多能容纳的体积是V。
 * 现在有n个物品，第i个物品的体积为v_iv
 * （1）求这个背包至多能装多大价值的物品？
 * （2）若背包恰好装满，求至多能装多大价值的物品？
 * 输入描述：
 * 第一行两个整数n和V，表示物品个数和背包体积。
 * 接下来n行，每行两个数表示第i个物品的体积和价值。
 * 输出描述：
 * 输出有两行，第一行输出第一问的答案，第二行输出第二问的答案，如果无解请输出0。
 */
public class A01Backpack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        //存放体积
        int[] v = new int[n + 1];
        //存放价值
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        // dp1[i]表示不考虑背包是否装满，在容量为i的情况下，最多装多大价值的物品
        int[] dp1 = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            // 由于每个物品只能用一次，为了防止重复计算，需要倒序遍历
            for (int j = V; j >= v[i]; j--) {
                // 状态转移，要么选择第i件物品，要么不选，取价值最大的
                dp1[j] = Math.max(dp1[j - v[i]] + w[i], dp1[j]);
            }
        }

        System.out.println(dp1[V]);


        int[] dp2 = new int[V + 1];
        Arrays.fill(dp2, Integer.MIN_VALUE);
        //没有物品时，价值为0
        dp2[0] = 0;
        for (int i = 1; i <= n; i++) {
            //由于每个物品只能用一次，为了防止重复计算，需要倒序遍历
            for (int j = V; j >= v[i]; j--) {
                //状态转移，要么选择第i件物品，要么不选，取价值最大的
                dp2[j] = Math.max(dp2[j - v[i]] + w[i], dp2[j]);
            }
        }
        //如果小于0，说明不能从初始状态转移过来，无解
        if (dp2[V] < 0) {
            dp2[V] = 0;
        }
        System.out.println(dp2[V]);
    }

}
