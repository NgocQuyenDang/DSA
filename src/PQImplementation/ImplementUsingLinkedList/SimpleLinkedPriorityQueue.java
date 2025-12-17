package PQImplementation.ImplementUsingLinkedList;

public interface SimpleLinkedPriorityQueue<E extends Comparable<E>> {

    /**
     * Thêm một phần tử mới vào hàng đợi.
     * @param element phần tử được thêm
     */
    void insert(E element);

    /**
     * Trả về và loại bỏ phần tử nhỏ nhất (ưu tiên cao nhất).
     * @return phần tử nhỏ nhất
     */
    E extractMin();

    /**
     * Trả về phần tử nhỏ nhất mà không loại bỏ.
     * @return phần tử nhỏ nhất
     */
    E peek();

    /**
     * Kiểm tra xem hàng đợi có rỗng không.
     * @return true nếu rỗng, ngược lại false
     */
    boolean isEmpty();

    /**
     * Trả về số phần tử hiện có trong hàng đợi.
     * @return số phần tử
     */
    int size();
}