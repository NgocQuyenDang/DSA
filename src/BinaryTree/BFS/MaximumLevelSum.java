package BinaryTree.BFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        int maxLevel = 1;
        q.offer(root);
        int maxSum = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        MaximumLevelSum obj = new MaximumLevelSum();
        System.out.println(obj.maxLevelSum(root));
    }
}
