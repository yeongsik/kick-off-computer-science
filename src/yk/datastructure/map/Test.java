package yk.datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        Map m = new HashMap<>();
//        m.put(1, 1); //object 반환
//        m.get(k); //object 반환
//        m.remove(k); //object 반환
//        m.remove(k,v); //boolean 반환
//        m.replace(k, v); //object 반환
//        m.replace(k, oldV, newV); //boolean 반환
//        m.containsKey(k);
//        m.hashCode();
//        m.keySet();
//        m.clear();

        MyMap test = new HashTable();
        test.put("first", 1);
        test.put("second", 2);
        System.out.println(test.contains("first"));
        System.out.println(test.get("second").toString());
        test.replace("second", 4);
        System.out.println(test.get("second").toString());
        test.clear();
        System.out.println(test.empty());
    }
}
