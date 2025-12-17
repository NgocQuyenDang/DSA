package PQImplementation.ImplementUsingHeap;

import java.util.Arrays;

public class HeapPriorityQueue<E extends Comparable<E>> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        heap = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Thêm một phần tử mới vào heap.
     *
     * @param i phần tử cần chèn
     * @throws IllegalArgumentException nếu phần tử là null
     */

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int leftChild(int i) {
        return (2 * i + 1);
    }

    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    public void swap (E[] heap, int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void insert(E element) {
        // TODO
        if (element == null) throw new IllegalArgumentException();
        if ( size == heap.length) enlarge();
        heap[size++] = element;
        percolateUp(size);
    }

    /**
     * Lấy (nhưng không xóa) phần tử nhỏ nhất trong heap.
     *
     * @return phần tử nhỏ nhất hoặc null nếu heap rỗng
     */
    public E peek() {
        // TODO
        return heap[0];
    }

    /**
     * Lấy và xóa phần tử nhỏ nhất trong heap.
     *
     * @return phần tử nhỏ nhất hoặc null nếu heap rỗng
     */
    public E extractMin() {
        // TODO
        E minValue = heap[0];
        heap[0] = heap[size - 1];
        percolateDown(0);
        size--;
        return minValue;
    }

    /**
     * Kiểm tra xem heap có rỗng không.
     *
     * @return true nếu heap rỗng, false nếu có phần tử
     */
    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    /**
     * Trả về số lượng phần tử hiện có trong heap.
     *
     * @return số phần tử trong heap
     */
    public int size() {
        return size;
    }

    /**
     * Hàm hỗ trợ đưa phần tử lên trên để duy trì tính chất của heap.
     *
     * @param index vị trí phần tử mới chèn
     */
    private void percolateUp(int index) {
        // TODO
        while (index > 0 && heap[parent(index)].compareTo(heap[index]) > 0) {
            swap(heap, index, parent(index));

            index = parent(index);
        }
    }

    /**
     * Hàm hỗ trợ đưa phần tử xuống dưới để duy trì tính chất của heap.
     *
     * @param index vị trí phần tử cần đưa xuống
     */
    private void percolateDown(int index) {
        // TODO
        int left = leftChild(index);
        int right = rightChild(index);
        int minIndex = index;

        if (left < size && heap[left].toString().compareTo(heap[minIndex].toString()) < 0) {
            minIndex = left;
        }

        if (right < size && heap[right].toString().compareTo(heap[minIndex].toString()) < 0 ) {
            minIndex = right;
        }

        if ( minIndex == index) return;

        E temp = heap[index];
        heap[index] = heap[minIndex];
        heap[minIndex] = temp;

        percolateDown(minIndex);
    }

    /**
     * Tăng gấp đôi dung lượng mảng khi hết chỗ.
     */
    @SuppressWarnings("unchecked")
    private void enlarge() {
        int newCapacity = heap.length * 2;
        E[] newHeap = (E[]) new Comparable[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    /**
     * Trả về chuỗi biểu diễn các phần tử trong heap theo thứ tự mảng.
     *
     * @return chuỗi chứa các phần tử của heap
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < heap.length; i++) {
            sb.append(heap[i]);
            if (i < heap.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}