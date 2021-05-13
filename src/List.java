
public interface List<T> extends Iterable<T> { // Diamond problem
    void add(T newItem);
    void addForward(T newItem);
    T removeLast();
    T removeFirst();
    T get(int index);
    int getSize(); // Go - no classes
    // Struct interface
}
