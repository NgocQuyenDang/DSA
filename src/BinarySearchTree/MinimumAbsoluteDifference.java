package BinarySearchTree;

public class MinimumAbsoluteDifference {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root, min, prev);
        return min;
    }

    public void inorder(TreeNode root, Integer prev, int minDiff) {
        if (root == null) {
            return;
        }
        inorder(root.left, prev, minDiff);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;
        inorder(root.right, prev, minDiff);
    }
}
