package per.zzz.algorithm.linearTable;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/1 10:15
 */
public class ThreeNumbers2 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE - 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int a = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                    if (a < min) {
                        min = a;
                        ans = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return ans;
    }
}
