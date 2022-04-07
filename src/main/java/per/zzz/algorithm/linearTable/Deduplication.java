package per.zzz.algorithm.linearTable;

import java.util.*;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/7 9:58
 */
public class Deduplication {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int k = 0;
        for (int num : nums) {
            if(!set.contains(num)){
                nums[k++] = num;
                set.add(num);
            }
        }
        return set.size();
    }
}
