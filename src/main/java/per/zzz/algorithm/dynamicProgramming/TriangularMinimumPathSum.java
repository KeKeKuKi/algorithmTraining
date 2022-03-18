package per.zzz.algorithm.dynamicProgramming;

import java.util.List;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/18 15:14
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class TriangularMinimumPathSum {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int i = n-1;
        while(i-- > 0) {
            for (int j = 0; j < i+1; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
