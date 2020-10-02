package stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable {

    private LinkedList<T> list;

    public Stack() {
        this.list = new LinkedList<>();
    }

    public void push(T element){
        list.addLast(element);
    }

    public T pop(){
        if(list.isEmpty()){
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    public T peek(){
        if(list.isEmpty()){
            throw  new EmptyStackException();
        }

        return list.getLast();
    }

    public Boolean isEmpty(){
        return list.size()==0;
    }

    public Integer size(){
        return list.size();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
