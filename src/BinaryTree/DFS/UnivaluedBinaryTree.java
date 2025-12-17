package BinaryTree.DFS;
import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        int constant = root.val;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curVal = curNode.val;
            if (curVal != constant) {
                return false;
            }

            if (curNode.left != null) queue.add(curNode.left);
            if (curNode.right != null) queue.add(curNode.right);
        }
        return true;
    }
}
