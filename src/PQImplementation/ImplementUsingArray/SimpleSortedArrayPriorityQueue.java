package PQImplementation.ImplementUsingArray;

public class SimpleSortedArrayPriorityQueue<E extends Comparable<E>> implements SimpleArrayPriorityQueue<E> {
    
    private final int DEFAULT_CAPACITY = 2;
    private E[] data = (E[]) new Comparable[DEFAULT_CAPACITY];
    private int size = 0;
    

    @Override
    public void insert(E element) {
        // TODO
        if (size == data.length) {
            this.enlarge();
        }
        data[size++] = element;
        int elementIdx = size - 1;
        for (int i = size - 2; i >= 0; i--) {
            if (element.compareTo(data[i]) < 0) {
                swap(data, i, elementIdx);
                elementIdx = i;
            }
        }
    }

    public void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public E extractMin() {
        // TODO
        E min = data[0];

        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return min;
    }

    @Override
    public E peek() {
        // TODO
        return data[0];
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
    
    private void enlarge() {
        int newCapacity = data.length * 2;
        E[] newData = (E[]) new Comparable[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}