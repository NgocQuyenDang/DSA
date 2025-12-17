package Queue;

public class MyCircularQueue {
    int numberOfElm;
    int size;
    Node front;
    Node rear;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public MyCircularQueue(int k) {
        this.size = k;
        this.numberOfElm = 0;
    }

    public boolean enQueue(int value) {
        if (front == null) {
            front = rear = new Node(value);
            numberOfElm++;
            return true;
        } else if (numberOfElm < size) {
            rear.next = new Node(value);
            numberOfElm++;
            rear = rear.next;
            rear.next = front;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        numberOfElm--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return front.data;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return numberOfElm == size;
    }
}
