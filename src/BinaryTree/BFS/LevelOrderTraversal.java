package BinaryTree.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    /**
     * Duyệt cây theo chiều ngang (từ gốc xuống, trái sang phải) và in ra các phần tử cách nhau bởi một dấu cách.
     * @param root nút gốc của cây
     */
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public void levelOrderTraversal(Node root) {
        // TODO
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
