package PQImplementation.ImplementUsingLinkedList;

public class SimpleUnsortedLinkedPriorityQueue<E extends Comparable<E>> implements SimpleLinkedPriorityQueue<E> {

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
        if (isEmpty()) {
            head = new Node<>(element);
        } else {
            Node<E> node = new Node<>(element);
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public E extractMin() {
        // TODO
        Node<E> min = head;
        Node<E> cur = head;
        while (cur != null) {
            if (cur.data.compareTo(min.data) < 0) {
                min = cur;
            }
            cur = cur.next;
        }
        if (min == head) head = head.next;
        else {
            cur = head;
            while (cur.next != null && cur.next.data.compareTo(min.data) != 0) {
                cur = cur.next;
            }
            cur.next = min.next;
        }
        size--;
        return min.data;
    }

    @Override
    public E peek() {
        // TODO
        Node<E> min = head;
        Node<E> cur = head;
        while (cur != null) {
            if (cur.data.compareTo(min.data) < 0) {
                min = cur;
            }
            cur = cur.next;
        }
        return min.data;
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