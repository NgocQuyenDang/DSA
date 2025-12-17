package FinalExam.Task1;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"unchecked", "deprecation"})
class CheckSiblings  {
    public boolean areSiblings(Node root, int val1, int val2) {
        Queue<Node> q  = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if ((cur.left != null && (cur.left.value ==val1 || cur.left.value ==val2)
                && (cur.right != null && (cur.right.value ==val1 || cur.right.value ==val2)))) {
                return true;
            }
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        return false;
    }

    public boolean dfs(Node root, int val1, int val2) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {
            if (root.left.value == val1 && root.right.value == val2) {
                return true;
            }
            if (root.left.value == val2 && root.right.value == val1) {
                return true;
            }
        }
        return dfs(root.left, val1, val2) || dfs(root.right, val1, val2);
    }
}