package per.zzz.algorithm.breadthFirst;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/14 14:44
 * <p>
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class BiggestIsland {
    private static Integer max = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        int newMax = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                max = 0;
                maxIsLand(grid, i, j);
                newMax = Math.max(newMax, max);
            }
        }
        return newMax;
    }

    public static void maxIsLand(int[][] image, int i, int j) {
        if (!(i < 0 || i >= image.length || j < 0 || j >= image[0].length) && image[i][j] == 1) {
            image[i][j] = 0;
            max++;
            maxIsLand(image, i + 1, j);
            maxIsLand(image, i - 1, j);
            maxIsLand(image, i, j + 1);
            maxIsLand(image, i, j - 1);
        }
    }

}
