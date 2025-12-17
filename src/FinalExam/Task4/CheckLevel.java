package FinalExam.Task4;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"unchecked", "deprecation"})
class CheckLevel  {
    public boolean isSameLevel(Node root, int val1, int val2) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level1 = -1;
        int level2 = -1;
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node cur = queue.poll();
                if (cur.value == val1) {
                    level1 = level;
                }
                if (cur.value == val2) {
                    level2 = level;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            level++;
        }
        return level1 == level2 && level1 != -1;
    }

}