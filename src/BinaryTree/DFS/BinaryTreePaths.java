package BinaryTree.DFS;
import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            dfs(root, "", result);
        }
        return result;
    }

    void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) return;

        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        path += "->";
        dfs(root.left, path, res);
        dfs(root.right, path, res);
    }
}
