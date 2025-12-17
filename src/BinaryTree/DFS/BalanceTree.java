package BinaryTree.DFS;

import BinaryTree.TreeNode;

public class BalanceTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = Math.abs(findDepth(root.left) - findDepth(root.right));
        if (diff > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int findDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }
}
