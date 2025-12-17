package Set;

import java.util.ArrayList;

class MyHashSet {

    ArrayList<Integer> list;
    public MyHashSet() {
        this.list = new ArrayList();
    }

    public void add(int key) {
       if (!list.contains(key)) {
           list.add(key);
       }
    }

    public void remove(int key) {
        list.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        return list.contains(key);
    }
}

/**
 * Your Set.MyHashSet object will be instantiated and called as such:
 * Set.MyHashSet obj = new Set.MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */