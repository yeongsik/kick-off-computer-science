package yk.datastructure.list;

import java.util.LinkedList;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E data) {
            value = data;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }


    //5가지 경계조건
    //1. 데이터가 비어있는 경우
    //2. 단일 element인 경우
    //3. 처음 데이터 삽입
    //4. 맨마지막에 데이터 삽입
    //5. 중간에 데이터 삽입


    private Node<E> getNodeByIndex(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();                                  //2
        }

        Node<E> ptr = head;                                                         //1
        int i = 0;                                                                  //1
        while (ptr.next != null) {                                                  //n
            if(i < index){
                ptr = ptr.getNext();
                i++;
            }
            break;
        }
        return ptr;
    }                                                                               //O(N)

    public boolean isValidIndex(int index) {
        return 0 <= index & index < size;                                          // 2
    }


    public void add(int index, E data) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();                                  //2
        }

        if (index == 0) {
            addFirst(data);
        }

        Node<E> newNode = new Node<>(data);
        Node<E> beforeNode = getNodeByIndex(index - 1);                           //1, 3n + 5, -1
        newNode.next = beforeNode.next;                                           //1 + 1
        beforeNode.next = newNode;
        size++;                                                                   //1
    }                                                                             //O(N)

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        return;
    }

    public void addLast(E data) {
        add(size, data);
    }


    public void remove(int index) {
        if (size == 0) return;                                                      // 1

        Node<E> delNode = null;                                                     // 1
        Node<E> beforeNode = null;                                                  // 1

        if (isValidIndex(index)) {                                                  // 2
        delNode = getNodeByIndex(index);                                            // 3n + 5
            if (0 < index) {                                                        // case 1: 1 + 1 + 3n + 5
                beforeNode = getNodeByIndex(index - 1);
            } else {                                                                // case 2: 1
                beforeNode = head;
            }
        }
        beforeNode.setNext(delNode.next);                                           // 1
        size--;                                                                     // 1
}                                                                                   // 6n + 17 —> O(N)
    public void clear(){
        head = null;
    }

    public boolean contain(E data) {
        Node<E> ptr = head;                                                        // 1

        while (ptr != null) {                                                      // n
            if(ptr.getValue().equals(data)){
                return true;
            }
        }
        return false;
    }                                                                              //O(N)
}


