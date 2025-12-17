package ZMidterm.Mid1;

public interface QueueInterface<T> {
    public void enqueue(T element);

    public T dequeue();

    public boolean isEmpty();

}
