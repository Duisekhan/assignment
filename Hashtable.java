package com.company;

import java.util.Hashtable;
import java.util.LinkedList;

class HashTable {

    public static class HTObject {
        public String key;
        public Integer value;
    }

    public static final int ARR_SIZE = 128;
    private LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];

    public HashTable() {
        //init vals in array
        for(int i=0; i<ARR_SIZE; i++) {
            arr[i] = null;
        }
    }

    private HTObject getObj(String key) {
        if(key == null)
            return null;

        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];

        if(items == null)
            return null;

        for(HTObject item : items) {
            if(item.key.equals(key))
                return item;
        }

        return null;
    }

    public Integer get(String key) {
        HTObject item = getObj(key);

        if(item == null)
            return null;
        else
            return
                    item.value;
    }

    public void put(String key, Integer value) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HTObject>();

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);

            arr[index] = items;
        }
        else {
            for(HTObject item : items) {
                if(item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);
        }
    }

    public void delete(String key) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];

        if(items == null)
            return;

        for(HTObject item : items) {
            if (item.key.equals(key)) {
                items.remove(item);
                return;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        HashTable Htable = new HashTable();
        Htable.put("A", 1845);
        Htable.put("S", 1835);
        Htable.put("M", 1885);
        Htable.put("L", 604);

        System.out.println(Htable.get("A"));
        System.out.println(Htable.get("L"));
        Htable.delete("L");
        System.out.println(Htable.get("L"));
        System.out.println(Htable.get("M"));

    }
}
