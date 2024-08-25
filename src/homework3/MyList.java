package homework3;

public interface MyList<T> {
    T get(int index);
    void set(int index, T element);
    void add(T element);
    void remove(int index);
    int size();
    T[] toArray();

}
