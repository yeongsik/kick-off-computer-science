package ys.datastructure.map;

import java.util.LinkedList;
import java.util.Objects;

public class HashMap <K,V>implements Map<K,V>{

    static class Node<K,V> {
        private K key;
        private V value;

        Node(K key , V value) {
            this.key = key;
            this.value = value;
        }
        V getValue(){
            return this.value;
        }

        K getKey(){
            return this.key;
        }

        void setValue(V value) {
            this.value = value;
        }
    }
    private static final int DEFAULT_CAPACITY = 16;

    private LinkedList<Node>[] tab;

    private int size;

    public HashMap(){
        tab = new LinkedList[DEFAULT_CAPACITY];
    }

    public HashMap(int capacity) {
        tab = new LinkedList[capacity];
    }

    @Override
    // TODO: 2022-07-27 해당 배열방이 비어있을 떄랑 아닐 때 추상화 수준 높이기
    public void put(K key, V value) {
        int index = convertToIndex(Objects.hash(key));
        if(Objects.isNull(tab[index])) {
            tab[index].addFirst(new Node(key, value));
            size++;
            return;
        }

        if(!Objects.isNull(tab[index])){
            Node sameNode = searchNode(tab[index], key);
            if(!Objects.isNull(sameNode)) {
                sameNode.setValue(value);
            }
            if(Objects.isNull(sameNode)) {
                tab[index].addLast(new Node(key, value));
                size++;
            }
            return;
        }
    }

    @Override
    public Object get(K key) {
        int index = convertToIndex(Objects.hash(key));
        if(!Objects.isNull(tab[index])){
            return searchNode(tab[index],key).getValue();
        }
        return null;
    }

    @Override
    public void delete(K key) {
        int index = convertToIndex(Objects.hash(key));
        if(!Objects.isNull(tab[index])) {
            Node sameNode = searchNode(tab[index], key);
            tab[index].remove(sameNode.getKey());
            size--;
        }
    }

    @Override
    public void clear() {
        for ( int i = 0; i<tab.length; i++) {
            tab[i] = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int convertToIndex(int hash) {
        return hash % tab.length;
    }

    private Node searchNode(LinkedList<Node> linkedList , K key){
        for ( int i =0; i<linkedList.size(); i++) {
            Node node = linkedList.get(i);
            if(node.getKey().equals(key)) {
                return node;
            }
        }
        return null;
    }
}
