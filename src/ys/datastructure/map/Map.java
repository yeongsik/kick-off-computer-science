package ys.datastructure.map;

public interface Map<K,V> {

    void put (K key , V value);

    Object get ( K key );

    void delete ( K key);

    void clear ();

    int size();

}
