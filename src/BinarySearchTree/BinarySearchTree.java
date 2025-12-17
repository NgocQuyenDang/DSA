package BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public void insert(Node node){
        root = insertHelper(root, node);
    }
    public Node insertHelper(Node root, Node node) {
        if (root == null) {
            root = node;
            return root;
        }
        int data = node.data;
        if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display(){
        displayHelper(root);
    }
    public void displayHelper(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        displayHelper(root.left);
        displayHelper(root.right);
    }
    public boolean search(int data){
        return searchHelper(root, data);
    }
    public boolean searchHelper(Node root, int data){
        if (root == null) return false;
        if (root.data == data) return true;
        if (data < root.data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }
}
