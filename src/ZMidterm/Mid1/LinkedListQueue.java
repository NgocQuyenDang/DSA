package ZMidterm.Mid1;

@SuppressWarnings("unchecked")
public class LinkedListQueue<T>  implements QueueInterface<T>{

    class Node {
        T element;
        Node next;

        public Node(T element) {
            this.element = element;
        }
    }

    Node front;
    Node rear;

    @Override
    public void enqueue(T element) {
        // TODO Auto-generated method stub
        Node newNode = new Node(element);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        if  (front == null) {
            return null;
        }

        T res = front.element;
        front = front.next;

        if  (front == null) {
            rear = null;
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return front == null;
    }

}

