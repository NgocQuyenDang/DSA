package BinaryTree.DFS;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode temp = list.get(i);
            temp.left = null;
            temp.right = list.get(i + 1);
        }
    }

    void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
