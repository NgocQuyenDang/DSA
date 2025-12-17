package BinaryTree.BFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.offer(root.left);
        right.offer(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode leftTree = left.poll();
            TreeNode rightTree = right.poll();
            if (leftTree == null && rightTree == null) continue;
            if (leftTree == null || rightTree == null) return false;
            if (leftTree.val != rightTree.val) return false;

            left.offer((leftTree.left));
            left.offer(leftTree.right);
            right.offer((rightTree.right));
            right.offer(rightTree.left);
        }
        return true;
    }
}
