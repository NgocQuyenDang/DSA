package BinarySearchTree;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }
        return validate(root.left, min, root.val - 1) &&  validate(root.right, root.val + 1, max);
    }
}
