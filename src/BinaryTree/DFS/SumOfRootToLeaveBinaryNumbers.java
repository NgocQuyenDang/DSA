package BinaryTree.DFS;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeaveBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        sumPath(root,"",list);
        int sum = 0;
        for (String s : list){
            sum += binaryToDecimal(s);
        }
        return sum;
    }

    public int binaryToDecimal(String binary) {
        int sum = 0;
        int exp = binary.length()-1;
        for (int i = 0; i < binary.length(); i++) {
            sum += Math.pow(2, exp) * Integer.valueOf(String.valueOf(binary.charAt(i)));
            exp--;
        }
        return sum;
    }

    public void sumPath(TreeNode root, String path, List<String> list) {
        if (root == null) {
            return;
        }

        path += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(path);
        }
        sumPath(root.left, path, list);
        sumPath(root.right, path, list);
    }
}
