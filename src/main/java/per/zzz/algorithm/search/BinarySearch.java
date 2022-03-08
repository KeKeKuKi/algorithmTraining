package per.zzz.algorithm.search;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/8 9:35
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if(target < nums[0]) return -1;
        if(target > nums[nums.length - 1]) return -1;
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    /**
     *  递归式
     */
    public int searchInsert(int[] nums, int target,int left, int right){
        int index = (left + right) / 2;
        int number = nums[index] ;
        if(number == target){
            return index;
        }
        if(left == right){
            return -1;
        }
        if(number < target){
            return searchInsert(nums, target, index + 1, right);
        }else{
            return searchInsert(nums, target, left, index - 1);
        }
    }
}
