package ys.datastructure.list;

public class DoublyLinkedList implements List {

    private Node head;
    private Node tail;
    private int size;

    private static class Node<E> {
        private Node<E> previous;
        private Node<E> next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

    }
    @Override
    public void addHead(Object obj) {
        if(this.head == null) {

            this.head = new Node(obj);
            this.tail = this.head;
            size++;
            return;
        }
        if(this.head !=null) {
            Node newNode = new Node(obj);
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
            size++;
        }
    }

    @Override
    public void addMiddle(Object obj, int index) {
        if(isFirstIndex(index)) {
            addHead(obj);
            return;
        }

        if(isLastIndex(index)) {
            add(obj);
            return;
        }
        Node selectedNode = getNode(index);
        Node prevNode = selectedNode.previous;
        Node newNode = new Node(obj);

        selectedNode.previous = newNode;
        newNode.next = selectedNode;
        newNode.previous = prevNode;
        prevNode.next = newNode;

        size++;
    }

    @Override
    public void add(Object obj) {

        if(isEmptyList()) {
            addHead(obj);
            return;
        }

        Node newNode = new Node(obj);
        Node tempTailNode = this.tail;
        tempTailNode.next = newNode;

        this.tail = newNode;
        this.tail.previous = tempTailNode;

        size++;
    }

    @Override
    public void remove(int index) {
        Node selectedNode = getNode(index);
        if(isHead(selectedNode)) {
            removeFirst();
            return;
        }
        if(isTail(selectedNode)) {
            removeLast();
            return;
        }
        Node temp2 = selectedNode.next;
        Node temp1 = selectedNode.previous;
        temp2.previous = temp1;
        temp1.next = temp2;

        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object get(int index) {
        return getNode(index).data;
    }

    private Node getNode(int index) {
        validateList(index);

        if (isFirstIndex(index)) {
            return this.head;
        }
        if (isLastIndex(index)) {
            return this.tail;
        }
        if(isOverMidIndex(index)) {
            return findNodeBack(index);
        }
        return findNodeFront(index);
    }
    private boolean isOverIndex(int index) {
        boolean result = false;

        if(index > this.size-1) {
            result = true;
        }

        return result;
    }

    private boolean isOverMidIndex(int index) {
        boolean result = false;
        if(index > getMidIndex()) {
            result = true;
        }
        return result;
    }

    private int getMidIndex() {
        return this.size/2;
    }

    private boolean isFirstIndex (int index) {
        boolean result = false;
        if(index == 0) {
            result = true;
        }
        return result;
    }
    private boolean isLastIndex (int index) {
        boolean result = false;
        if(index == this.size-1) {
            result = true;
        }
        return result;
    }

    private void removeFirst() {
        if(this.size ==1) {
            this.head = null;
            this.tail = null;
            size = 0;
            return;
        }

        Node tempHead = this.head.next;
        tempHead.previous = null;
        this.head = tempHead;
        size--;
    }

    private void removeLast() {
        Node tempTail = this.tail.previous;
        tempTail.next = null;
        this.tail = tempTail;
        size--;
    }

    private Node findNodeFront(int index) {
        Node returnNode = null;
        for(int i = 0; i < index; i++) {
            returnNode = head.next;
        }
        return returnNode;
    }

    private Node findNodeBack(int index) {
        Node returnNode = null;
        for (int i = size-1; i >= index; i--) {
            returnNode = tail.previous;
        }

        /*
        for ( int i = 0; i < size-index; i++ ) {
            returnNode = tail.previous;
        }
        */
        return returnNode;
    }
    private boolean isEmptyList() {
        boolean result = false;
        if (this.head == null && this.tail == null && this.size == 0) {
            result = true;
        }
        return result;
    }
    private void validateList(int index) {
        if (isEmptyList()) {
            throw new IndexOutOfBoundsException("비어있습니다.");
        }
        if (isOverIndex(index)) {
            throw new IndexOutOfBoundsException("인덱스가 리스트 사이즈에 초과했습니다.");
        }
    }

    private boolean isHead(Node node) {
        boolean result = false;
        if(node.previous == null) {
            result = true;
        }
        return result;
    }
    private boolean isTail(Node node) {
        boolean result =  false;
        if(node.next == null) {
            result = true;
        }
        return result;
    }
}
