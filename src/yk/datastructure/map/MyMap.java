package yk.datastructure.map;

public interface MyMap<String, E> {
    public void put(String key, E value);
    public Object get(String key);
    public boolean remove(String key);
    public void replace(String key, E value);
    public boolean contains(String key);
    public void clear();
    public boolean empty();
}
