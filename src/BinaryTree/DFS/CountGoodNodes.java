package BinaryTree.DFS;
import BinaryTree.TreeNode;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxVal) {
        if (root == null) return 0;

        int res = root.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, root.val);
        res += dfs(root.left, maxVal) + dfs(root.right, maxVal);
        return res;
    }
}
