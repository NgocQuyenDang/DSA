package BinarySearchTree;

public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBST(root.right, low, high);
    }
}
