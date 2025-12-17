package BinaryTree.DFS;

import BinaryTree.TreeNode;

public class BinaryTreeTilt {
    int sumTilt = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return sumTilt;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        sumTilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
