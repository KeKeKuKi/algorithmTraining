package per.zzz.algorithm.breadthFirst;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/14 14:23
 * <p>
 * 733. 图像渲染
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
 * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，
 * 重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
 * 最后返回 经过上色渲染后的图像 。
 */
public class PaintBucketTool {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return dfs(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] dfs(int[][] image, int i, int j, int newColor, int num) {
        if (!(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || image[i][j] != num)) {
            image[i][j] = newColor;
            dfs(image, i + 1, j, newColor, num);
            dfs(image, i - 1, j, newColor, num);
            dfs(image, i, j + 1, newColor, num);
            dfs(image, i, j - 1, newColor, num);
        }
        return image;
    }

}
