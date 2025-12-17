package PQImplementation.ImplementUsingLinkedList;

public class SimpleSortedLinkedPriorityQueue<E extends Comparable<E>> implements SimpleLinkedPriorityQueue<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head = null;
    private int size = 0;

    @Override
    public void insert(E element) {
        // TODO
        Node<E> node = new Node<>(element);
        if (isEmpty() || element.compareTo(head.data) < 0) {
            node.next = head;
            head = node;
            size++;
            return;
        } else {
            Node<E> cur = head;
            while (cur.next != null && cur.next.data.compareTo(element) < 0) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        size++;
    }

    @Override
    public E extractMin() {
        // TODO
        Node<E> min = head;
        head = head.next;
        return min.data;
    }

    @Override
    public E peek() {
        // TODO
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return head == null;
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }
}