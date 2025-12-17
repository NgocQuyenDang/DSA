package BinarySearchTree;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k, pq);
        return pq.peek();
    }

    public void inorder(TreeNode root, int k, Queue<Integer> pq) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, pq);
        pq.add(root.val);
        if (pq.size() > k) {
            pq.poll();
        }
        inorder(root.right, k, pq);
    }
}
