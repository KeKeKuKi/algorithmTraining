package per.zzz.algorithm.doublePointer;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/9 13:44
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveAllZeroToEnd {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        // 找到第一个零位置
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            return;
        }
        // 从第一个零位置向后遍历覆盖前移非零元素，同时记录零元素个数
        int right = left + 1;
        int zeroCount = 1;
        for (; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            } else {
                zeroCount++;
            }
        }
        // 通过零元素个数从尾部向前覆盖为0
        for (int i = 0; i < zeroCount; i++) {
            nums[nums.length - i - 1] = 0;
        }
    }
}
