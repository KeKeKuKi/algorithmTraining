package per.zzz.algorithm.search;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/8 9:41
 *
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 */
public class BinarySearchAndGetIndex {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target,int left, int right){
        int index = (left + right) / 2;
        int number = nums[index] ;
        if(number == target){
            return index;
        }
        if(right - left == 1){
            return nums[right] == target ? right : target < nums[left] ? left : target < nums[right] ? right : right + 1;
        }
        if(left == right){
            return target < nums[left] ? left : left + 1;
        }
        if(number < target){
            return search(nums, target, index + 1, right);
        }else{
            return search(nums, target, left, index - 1);
        }
    }
}
