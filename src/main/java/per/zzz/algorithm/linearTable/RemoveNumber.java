package per.zzz.algorithm.linearTable;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/1 9:26
 */
public class RemoveNumber {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
