package BinaryTree.DFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 1;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return level;
    }
}
