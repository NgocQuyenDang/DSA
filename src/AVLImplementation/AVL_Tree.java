package AVLImplementation;

import java.util.*;

public class AVL_Tree {

    // A utility function to get the height
    // of the tree
    public int height(Node N) {
        return N.height;
    }

    // A utility function to right rotate
    // subtree rooted with y
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return x;
    }

    // A utility function to left rotate
    // subtree rooted with x
    public Node leftRotate(Node x) {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // Get Balance factor of node N
    public int getBalance(Node N) {
        return height(N.left) - height(N.right);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // Recursive function to delete a node with
    // given key from subtree with given root.
    // It returns root of the modified subtree.
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    return null;
                } else {
                    root = temp;
                }
            }
            else {
                    Node temp = minValue(root.right);

                    root.key = temp.key;

                    root.right = deleteNode(root.right, temp.key);
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public Node minValue(Node root) {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    // A utility function to print preorder
    // traversal of the tree.
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


}