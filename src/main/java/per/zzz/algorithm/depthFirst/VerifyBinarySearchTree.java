package per.zzz.algorithm.depthFirst;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/2 10:28
 */
public class VerifyBinarySearchTree {
    Long min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val > min) {
            min = (long) root.val;
        } else {
            return false;
        }
        return isValidBST(root.right);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
