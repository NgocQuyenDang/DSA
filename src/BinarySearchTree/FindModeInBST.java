package BinarySearchTree;

import java.util.*;

public class FindModeInBST {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int max  = Integer.MIN_VALUE;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
