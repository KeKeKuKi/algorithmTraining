package per.zzz.algorithm.other;

/**
 * 883. 三维形体投影面积
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 *
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 */
public class ThreeViewsArea {
    public int projectionArea(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int top = 0;
        int left = 0;
        int head = 0;

        for (int[] ints : grid) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] > 0) {
                    top++;
                }
                if (ints[j] > max) {
                    max = ints[j];
                }
            }
            left += max;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int[] ints : grid) {
                if (ints[i] > max) {
                    max = ints[i];
                }
            }
            head += max;
        }
        return top + left + head;
    }
}
