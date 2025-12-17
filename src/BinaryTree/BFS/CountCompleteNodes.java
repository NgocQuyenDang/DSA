package BinaryTree.BFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            count++;
        }
        return count;
    }
}
