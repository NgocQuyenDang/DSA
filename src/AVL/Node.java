package AVL;

public class Node {
    int key;
    Node left;
    Node right;
    int height;

    Node(int k) {
        key = k;
        left = right = null;
        height = 1;
    }
}
