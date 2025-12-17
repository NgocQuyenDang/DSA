package BinaryTree.DFS;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, targetSum, res, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int curSum, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        curSum += root.val;

        if (root.left == null && root.right == null) {
            if (curSum == targetSum) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, curSum, targetSum, res, path);
        dfs(root.right, curSum, targetSum, res, path);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSumII solver = new PathSumII();
        int targetSum = 22;

        List<List<Integer>> result = solver.pathSum(root, targetSum);

        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
