package per.zzz.algorithm.dynamicProgramming;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/7 10:50
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSum {
    public int maxSubArray(int[] nums) {
        int m = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            m = Math.max(m, nums[i]);
        }
        return m;
    }
}
