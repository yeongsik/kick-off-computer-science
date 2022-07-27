package yk.datastructure.map;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Objects;

public class HashTable<String, E> implements MyMap<String, E>{
    //Collision 대비 linkedList로 구현
    int size = 8;
    private LinkedList<Node>[] rooms = new LinkedList[size];
    private class Node{
        String key;
        E value;

        private Node(String key,E value){
            this.key = key;
            this.value = value;
        }
        private E value(){
            return this.value;
        }
        private void value(E value){
            this.value = value;
        }
    }
    //Node inner Class End.



    // 메서드 start
    private int getHashCode(String key) {
        return Objects.hashCode(key);
        // null 이면 0 반환

        // hash Func
        /*for(char c : key.toString().toCharArray()){
            hashCode += c;
        }*/
    }

    private int convertToIndex(int hashCode){
        int index = hashCode % rooms.length;
        if(index < 0) {
            index = index * -1;
        }
        return index;
    }

    private Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    // 추가
    public void put(String key, E value) {
        int index = getIndexOfRooms(key);
        LinkedList<Node> list = rooms[index];

        if(list == null){
            list = new LinkedList<Node>();
            rooms[index] = list;
        }

        Node node = searchKey(list, key); // list null 처리 되어있음.
        if(node == null){
            list.addLast(new Node(key, value));
        }else {
            node.value(value);
        }
        return;
    }

    // 반환
    public Object get(String key) {
        int index = getIndexOfRooms(key);
        LinkedList<Node> list = rooms[index];

        Node node = searchKey(list, key);
        return node == null? null : node.value();
    }

    // 제거
    public boolean remove(String key) {
        int index = getIndexOfRooms(key);
        LinkedList<Node> list = rooms[index];

        Node delNode = searchKey(list, key);
        return list.remove(delNode);
    }

    // 수정
    public void replace(String key, E value) {
        put(key, value);
    }

    // 방 주소 찾기
    private int getIndexOfRooms(String key){
        int hashCode = getHashCode(key);
        return convertToIndex(hashCode);
    }

    // 포함 여부
    public boolean contains(String key) {
        Object searchValue = get(key);
        return searchValue == null? false : true;
    }

    // 전체 삭제
    public void clear() {
        for(LinkedList<Node> room : rooms){
            if(room == null) continue;
            room.clear();
        }
    }

    // 데이터 비었는지 확인
    public boolean empty(){
        for(LinkedList<Node> room : rooms){
            if(room == null) continue;
            if(room.size() != 0) {
                return false;
            }
        }
        return true;
    }
    //메서드 end.
}
