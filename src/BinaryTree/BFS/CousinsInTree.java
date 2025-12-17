package BinaryTree.BFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                boolean foundX = false, foundY = false;
                if (node.val == x) {
                    foundX = true;
                }
                if (node.val == y) {
                    foundY = true;
                }
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.right.val == x && node.left.val == y)) {
                        return false;
                    }
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

                if (foundX && foundY) {
                    return true;
                }
                if (foundX != foundY) {
                    return false;
                }
            }
        }
        return false;
    }
}
