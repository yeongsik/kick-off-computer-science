package ys.datastructure.list;

public class DoublyLinkedList implements LinkedList {

    private static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

    }

    @Override
    public void addHead(Object obj) {
        Node newNode = new Node(obj);
    }

    @Override
    public void addMiddle(Object obj, int index) {

    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

//    public Node getNode(int index) {
//
//    }
}
