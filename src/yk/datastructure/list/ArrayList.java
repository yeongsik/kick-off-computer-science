package yk.datastructure.list;

import java.util.Arrays;

public class ArrayList<E> {
    private static final int DEFAULT_SIZE = 10;
    //데이터 갯수
    private int size;
    private E[] array;

    public ArrayList() {
        this.array = (E[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    private static <E> E[] extend(E[] originalArray) {
        return Arrays.copyOf(originalArray, originalArray.length * 2);
    }

    public void add(E value) {
        addLast(value);
    }

    public void add(int index, E value) {
        if (isNotValidIndex(index)) {                                       // 3
            throw new IndexOutOfBoundsException();
        }

        if (size == array.length) {                                         // 1
            array = extend(array);                                          // 1 + 1 = 2
        }

        //마지막 element부터 index까지 한 칸씩 뒤로 이동
        for (int i = size - 1; i >= index; i--) {                           // 1, n
            array[i + 1] = array[i];                                        // n
        }                                                                   // -> 2n + 1

        array[index] = value;                                               // 1
        size++;                                                             // 1
    }                                                                       // -> 2n + 9 --> O(2N) + 9 -- > O(N)

    private boolean isValidIndex(int index) {
        return 0 <= index || index < size;                                  // 1 + 1 = 2
    }

    private boolean isNotValidIndex(int index) {
        return !isValidIndex(index);                                        // 2 + 1 = 3
    }

    public void addFirst(E value) {
        add(0, value);
    }

    public void addLast(E value) {
        add(size, value);
    }

    public void remove(int index) {
        if (isNotValidIndex(index)) {                                       // 3
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size; i++) {                                // 1, n, n
            array[i] = array[i + 1];                                        // 1, 1, n
        }
        size--;                                                             // 1
    }                                                                       // --> 3n + 3 --> O(N)

    public void set(int index, E value) {
        if (isNotValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return array[index];                                                //O(1)
    }

    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {                                    //1 + n
            if (array[i].equals(value)) {                                   //1
                return true;                                                //1
            }
        }
        return false;
    }                                                                       //-> n + 3 --> O(N)

}