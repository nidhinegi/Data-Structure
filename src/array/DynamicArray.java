package array;

import java.util.Arrays;

public class DynamicArray<T> {

    private static final int DEFAULT_CAPACITY=1;
    private static final int MAX_CAPACITY=Integer.MAX_VALUE;
    private int capacity;
    private int length=0;

    Object[] array;

    public DynamicArray(){
        capacity=DEFAULT_CAPACITY;
        array=new Object[capacity];
    }

    public DynamicArray(int capacity){
        this.capacity=capacity;
        array=new Object[capacity];
    }

    public int getLength(){
        return length;
    }

    public int getCapacity(){
        return capacity;
    }

    public void incrementLength(){
        this.length+=1;
    }

    public void increaseCapacity(){
        if(capacity==MAX_CAPACITY){
            throw new OutOfMemoryError();
        }else if(capacity>MAX_CAPACITY/2)
            capacity=MAX_CAPACITY;
        else
            capacity=2*capacity;

        array=Arrays.copyOf(array,capacity);

    }

    public void add(T element){
        checkAndResizeArray(Boolean.TRUE);
        incrementLength();
        array[length-1]=element;
    }

    public void add(T element,int index){
        validateIndex(index);
        checkAndResizeArray(Boolean.TRUE);
        int position=length;
        incrementLength();
        while(position>index+1){
            array[position]=array[position-1];
            position--;
        }
        array[index]=element;
    }

    public void remove(){
        array[length]=null;
        decrementLength();
        checkAndResizeArray(Boolean.FALSE);
    }

    public void remove(int index){
        validateIndex(index);
        for(int i=index;i<length-1;i++){
            array[i]=array[i+1];
        }
        decrementLength();
        checkAndResizeArray(Boolean.FALSE);
    }

    private void decrementLength() {
        this.length-=1;
    }

    private void checkAndResizeArray(Boolean increasingCapacity) {
        if(increasingCapacity && length+1>capacity){
            increaseCapacity();
        }

        if(!increasingCapacity && capacity/2 > length) {
            decreaseCapacity();
        }

    }

    private void decreaseCapacity() {
        if(capacity>DEFAULT_CAPACITY)
            capacity/=2;
        array=Arrays.copyOf(array,capacity);
    }


    public T get(int index) throws IndexOutOfBoundsException {
        validateIndex(index);
        return (T)array[index];
    }

    private void validateIndex(int index) {
        if(index<0 || index>=length)
            throw new IndexOutOfBoundsException();
    }


}
