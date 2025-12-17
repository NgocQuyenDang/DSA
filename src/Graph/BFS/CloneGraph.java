package Graph.BFS;
import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val);
        map.put(node, clone);

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei,new Node(nei.val));
                    q.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return clone;
    }
}
