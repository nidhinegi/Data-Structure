package list;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    private class Node<T> {

        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value,Node next) {
            this.value = value;
            this.next=next;
        }

        public Boolean hasNext(){
            return next!=null;
        }
    }
    public SinglyLinkedList(Node head) {
        this.head = head;
        incrementSize();
    }

    public SinglyLinkedList() {
        this.head = null;
        size=0;
    }

    private void incrementSize(){
        size+=1;
    }

    private void decrementSize(){
        size-=1;
    }

    public int size(){
        return size;
    }

    public Boolean isEmpty(){
        return size()==0;
    }

    //Add element to the end of list. Time Complexity : O(n)
    public void add(T element){
        Node newNode=new Node(element);
        if(isEmpty()){
            head=newNode;
        }else{
            Node tempNode=head;
            while (tempNode.hasNext()){
                tempNode=tempNode.next;
            }

            tempNode.next=newNode;
        }

        incrementSize();
    }

    //Add element to the head.Time Complexity : O(1)
    public void addAtHead(T element){
        Node node=new Node(element,head);
        head=node;
        incrementSize();
    }

    /* Add a node before the index-th node in the linked list. If index equals to the length of linked list,
    the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
    Time Complexity : O(n)*/
    public void add(T element,int index){
        if(index==0)
            addAtHead(element);
        else  {
            int i=0;
            Node current=head;
            Node previous=null;
            while (i<index && current!=null){
                previous=current;
                current=current.next;
                i++;
            }

            if(previous!=null){
                previous.next=new Node(element,previous.next);
                incrementSize();
            }
        }

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return null
     * Time Complexity : O(n) */
    public T get(int index) {
        if(index>size())
            return null;
        int i=0;
        Node current=head;
        while (i<index && current!=null){
            current=current.next;
            i++;
        }

        if(current!=null){
            return (T) current.value;
        }else{
            return null;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. Time Complexity : O(n)*/
    public void deleteAtIndex(int index) {
        if(!isEmpty() && index<size()){
            int i=0;
            Node current=head;
            Node previous=null;
            while (i<index && current!=null){
                previous=current;
                current=current.next;
                i++;
            }

            if(previous==null)
                deleteFromHead();
            else{
                previous.next=current.next;
                decrementSize();
            }
        }
    }

    /** Delete element from head of list. O(1) */
    public void deleteFromHead() {
        if(!isEmpty()){
            head=head.next;
            decrementSize();
        }
    }
}
