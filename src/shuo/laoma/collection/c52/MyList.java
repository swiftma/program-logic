package shuo.laoma.collection.c52;

import java.util.AbstractList;
import java.util.Collection;

public class MyList<E> extends AbstractList<E> {
    private DynamicArray<E> darr;
    
    public MyList(){
        darr = new DynamicArray<>();
    }
    
    public MyList(Collection<? extends E> c){
        this();
        addAll(c);
    }
    
    @Override
    public E get(int index) {
        return darr.get(index);
    }

    @Override
    public int size() {
        return darr.size();
    }

    @Override
    public E set(int index, E element) {
        return darr.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        darr.add(index, element);
    }

    @Override
    public E remove(int index) {
        return darr.remove(index);
    }
}    
