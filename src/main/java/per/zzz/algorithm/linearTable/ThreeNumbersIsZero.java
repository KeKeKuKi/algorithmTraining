package per.zzz.algorithm.linearTable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/31 14:55
 */
public class ThreeNumbersIsZero {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> res = new ArrayList<>(3);
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        Collections.sort(res);
                        ans.add(res);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

}
