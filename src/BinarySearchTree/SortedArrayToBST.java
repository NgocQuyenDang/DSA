package BinarySearchTree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return arrayToBinarySearchTree(nums, 0, nums.length - 1);
    }

    public TreeNode arrayToBinarySearchTree(int[] nums, int low, int high) {
        TreeNode root = null;
        if (low <= high) {
            int mid = low  + (high - low) / 2;
            root = new TreeNode(nums[mid]);
            root.left = arrayToBinarySearchTree(nums, low, mid - 1);
            root.right = arrayToBinarySearchTree(nums, mid + 1, high);
        }
        return root;
    }
}
