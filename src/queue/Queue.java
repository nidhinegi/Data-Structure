package queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable {

    LinkedList<T> list;

    public Queue(){
        list=new LinkedList<>();
    }

    public Queue(T element){
        list=new LinkedList<>();
        addToLast(element);
    }

    private void addToLast(T element){
        list.add(element);
    }
    public int size(){
        return list.size();
    }

    public Boolean isEmpty(){
        return list.size()==0;
    }

    public void enQueue(T element){
        addToLast(element);
    }

    public void deQueue(T element){
        if(isEmpty()){
            throw new RuntimeException("Empty Queue");
        }
        list.removeFirst();
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Empty Queue");
        }
        return list.getFirst();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
