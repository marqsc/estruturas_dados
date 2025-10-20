public interface Stackable<T>{
    T pop();
    void push (T data);
    void update (T newData);
    T peek();

    boolean isEmpty();
    boolean isFull();
    String print();
} 