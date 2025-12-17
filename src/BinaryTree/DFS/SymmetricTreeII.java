package BinaryTree.DFS;

import BinaryTree.TreeNode;

public class SymmetricTreeII {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null ||  root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        return isSymmetric(root.left) && isSymmetric(root.right);
    }
}
