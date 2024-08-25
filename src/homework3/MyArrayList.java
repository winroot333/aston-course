package homework3;

import java.util.*;

public class MyArrayList<T> implements MyList<T> {
    private final int DEFAULT_SIZE = 10;
    private final double ARRAY_INCREASE_VAL = 1.5;

    private T[] array;
    private int listSize = 0;

    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size) {
        if (size > 1)
            this.array = (T[]) new Object[size];
        else {
            throw new IndexOutOfBoundsException("Array size should not be less than 1");
        }
    }

    public MyArrayList(Collection<T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public T[] toArray() {
        T[] temp = (T[]) new Object[this.size()];
        System.arraycopy(this.array, 0, temp, 0, this.size());
        return temp;
    }

    @Override
    public void add(T element) {
        checkArraySize(1);
        array[listSize] = element;
        listSize++;

    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size());
        System.arraycopy(this.array, index + 1, this.array, index, this.listSize - index - 1);
        this.listSize--;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, this.listSize);
        return array[index];
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, this.listSize);
        array[index] = element;
    }

    private void checkArraySize(int elementCount) {
        long sizeNeeded = this.listSize + elementCount;

        // Если массив полон увеличиваем его в ARRAY_INCREASE_VAL
        if (sizeNeeded > this.array.length) {
            long newArraySize = (long) Math.ceil((this.array.length + elementCount) * ARRAY_INCREASE_VAL);

            // Проверка чтобы новый массив был не больше Integer.MAX_VALUE
            // long выше ради этой проверки
            if (newArraySize > Integer.MAX_VALUE) {
                newArraySize = sizeNeeded + 1;
                if (newArraySize > Integer.MAX_VALUE) {
                    throw new IndexOutOfBoundsException("List size should not be greater than Integer.MAX_VALUE");
                }
            }
            this.resizeArray((int) newArraySize);
        }
    }

    private void resizeArray(int newArraySize) {
        T[] tmpArr = this.array;
        this.array = (T[]) new Object[newArraySize];
        if (this.listSize >= 0) System.arraycopy(tmpArr, 0, this.array, 0, this.listSize);
    }


    public void addAll(Collection<T> collection) {
        addAll((T[]) collection.toArray());
    }

    public void addAll(MyList<T> list) {
        addAll(list.toArray());
    }

    private void addAll(T[] arr) {
        checkArraySize(arr.length);
        System.arraycopy(arr, 0, this.array, this.listSize, arr.length);
        this.listSize += arr.length;
    }

    public void bubbleSort(Comparator<T> comparator) {

        boolean flag;
        for (int i = 0; i < this.listSize; i++) {
            flag = false;
            for (int j = 0; j < this.listSize - i - 1; j++) {
                if (comparator.compare(this.array[j], this.array[j + 1]) > 0) {
                    T tmp = this.get(j);
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static <A extends Comparable<A>> void staticSort(List<A> list) {
        if (list == null) {
            return;
        }
        boolean flag;
        for (int i = 0; i < list.size() - 1; i++) {
            flag = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    A tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}

