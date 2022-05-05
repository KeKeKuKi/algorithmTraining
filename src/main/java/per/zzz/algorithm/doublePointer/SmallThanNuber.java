package per.zzz.algorithm.doublePointer;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 * 示例 1：
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 */
public class SmallThanNuber {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int mul = 1;
        int ans = 0;
        while(right<nums.length) {
            mul *= nums[right];
            while (mul >= k) {
                mul /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
