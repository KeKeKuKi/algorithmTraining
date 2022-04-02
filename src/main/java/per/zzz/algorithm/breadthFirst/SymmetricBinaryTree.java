package per.zzz.algorithm.breadthFirst;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/2 14:09
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode l, TreeNode r){
        if (l == null && r == null){
            return true;
        }
        if (l == null || r == null){
            return false;
        }

        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }

    public class TreeNode {
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
