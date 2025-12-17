package BinaryTree.BFS;

import BinaryTree.TreeNode;

import java.util.*;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            TreeNode node = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(list);
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
