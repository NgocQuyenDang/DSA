package ZMidterm.Mid2;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class DictList<T> implements ListInterface<T>{

    List<T> list;

    public DictList(){
        list = new ArrayList<T>();
    }
    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        list.add(data);
    }

    @Override
    public T get(int i) {
        // TODO Auto-generated method stub
        return list.get(i);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return list.isEmpty();
    }
}
