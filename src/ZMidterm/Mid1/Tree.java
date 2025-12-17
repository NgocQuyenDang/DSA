package ZMidterm.Mid1;

@SuppressWarnings("unchecked")
public class Tree<T> {

    class Node{
        T data;
        Node left;
        Node right;
    }

    void travel(Node tree)
    {
        QueueInterface<Node>  queue = new LinkedListQueue<>();
        queue.enqueue(tree);
        while(!queue.isEmpty())
        {
            Node temp = queue.dequeue();
            System.out.print(temp.data + " ");
            if (temp.left != null)
            {
                queue.enqueue(temp.left);
            }
            if (temp.right != null)
            {
                queue.enqueue(temp.right);
            }
        }
    }

}
