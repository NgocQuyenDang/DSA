package BinarySearchTree;

public class MinimumDistanceBetweenNodes {
    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(prev.val - root.val));
        }
        prev = root;
        dfs(root.right);
    }


}
