package BSTImplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {

    class Node{
        Key data;
        Node left, right;
        public Node(Key key)
        {
            this.data =  key;
        }
    }

    private Node root = null;
    int n = 0;
    @Override
    public void insert(Key k) {
        // TODO Auto-generated method stub
        root = insertHelper(root, k);
        n++;
    }

    public Node insertHelper(Node root, Key k) {
        if (root == null) return new Node(k);
        if (k.compareTo(root.data) > 0) {
            root.right = insertHelper(root.right, k);
        } else if (k.compareTo(root.data) < 0) {
            root.left = insertHelper(root.left, k);
        } else {
            return root;
        }
        return root;
    }

    @Override
    public Key search(Key k) {
        // TODO Auto-generated method stub
        Node  node = searchHelper(root, k);
        if (node == null) return null;
        return node.data;
    }

    public Node searchHelper(Node root, Key k) {
        if (root == null) return null;
        if (root.data.compareTo(k) == 0) return root;
        if (k.compareTo(root.data) > 0) {
            return searchHelper(root.right, k);
        } else if (k.compareTo(root.data) < 0) {
            return searchHelper(root.left, k);
        }
        return root;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        List<Key> keys = new ArrayList<>();
        inOrderHelper(root, keys);
        return keys.iterator();
    }

    public void inOrderHelper(Node root, List<Key> list) {
        if (root == null) return;
        inOrderHelper(root.left, list);
        list.add(root.data);
        inOrderHelper(root.right, list);
    }

    //duyệt cây theo thứ tự trước (tiền thứ tự)
    public void preTraverse()
    {
        preTraverseHelper(root);
    }

    public void preTraverseHelper(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preTraverseHelper(root.left);
        preTraverseHelper(root.right);
    }

    // duyệt cây theo thứ tự sau (hậu thứ tự)
    public void postTraverse() {
        postTraverseHelper(root);
    }

    public void postTraverseHelper(Node root) {
        if (root == null) return;
        postTraverseHelper(root.left);
        postTraverseHelper(root.right);
        System.out.println(root.data);
    }


    // duyệt cây theo thứ tự giữa (trung thứ tự)
    public void inTraverse() {
        inTraverseHelper(root);
    }

    public void inTraverseHelper(Node root) {
        if (root == null) return;
        inTraverseHelper(root.left);
        System.out.println(root.data);
        inTraverseHelper(root.right);
    }




    public static void main(String[] args) {
        SimpleBST<Integer> bst =  new SimpleBST<>();

        int[] data = {5,6,7,1,2,3,8,6,9,0};
        for(int i = 0 ; i < data.length ; i++)
            bst.insert(data[i]);

        System.out.println("All element in tree:");
        System.out.println("All element in tree:");
        int[] t = new int[data.length];
        int id = 0;
        for(int d:bst)
        {
            t[id] = d;
            id++;
        }

        Arrays.sort(t);
        for(int d:t)
        {
            System.out.print(d+" ");
        }

        System.out.println("");
        System.out.println("Size of tree = "+bst.size());

        System.out.println("Search key = 4> "+ bst.search(4));
        System.out.println("Search key = 6> "+bst.search(6));

        System.out.println("Pre-order tree traversal");
        bst.preTraverse();
        System.out.println("Post-order tree traversal");
        bst.postTraverse();
        System.out.println("In-order tree traversal");
        bst.inTraverse();

    }



}
