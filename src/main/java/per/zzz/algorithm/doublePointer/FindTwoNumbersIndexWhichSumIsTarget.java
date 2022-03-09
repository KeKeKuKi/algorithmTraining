package per.zzz.algorithm.doublePointer;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/9 13:52
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 */
public class FindTwoNumbersIndexWhichSumIsTarget {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int [] ans = new int [2];
        while (numbers[i] + numbers[j] != target){
            int m = (i + j) >>> 1;
            if (numbers[i] + numbers[m] > target) {
                j = m - 1;
            } else if (numbers[m] + numbers[j] < target) {
                i = m + 1;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
