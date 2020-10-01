package list;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node<T> {

        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node previous,Node next) {
            this.value = value;
            this.next=next;
            this.previous=previous;

        }

        public Boolean hasNext(){
            return next!=null;
        }
    }

    public DoublyLinkedList() {
        this.head=null;
        this.tail=null;
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

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node=getNode(index);
        return node!=null?node.value:-1;
    }

    private Node getNode(int index) {
        if(index>=size() || index<0)
            return null;
        if(index<=size/2){
            return getFromBeginning(index);
        }else {
            return getFromEnd(index);
        }
    }

    private Node getFromEnd(int index) {
        int i=size()-1;
        Node node=tail;
        while (i>index){
            node=node.previous;
            i--;
        }

        return node;

    }

    private Node getFromBeginning(int index) {
        int i=0;
        Node current=head;
        while (i<index){
            current=current.next;
            i++;
        }

        return current;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node=new Node(val,null,head);
        if(head==null){
            tail=node;
        }else{
            head.previous=node;
        }
        head=node;
        incrementSize();
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(isEmpty()){
            addAtHead(val);
        }else{
            Node node=new Node(val,tail,null);
            tail.next=node;
            tail=node;
            incrementSize();
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==0)
            addAtHead(val);
        else if(index==size())
            addAtTail(val);
        else if(index>0 && index<size){
            Node node=getNode(index);
            Node newNode=new Node(val,node.previous,node);
            node.previous.next=newNode;
            node.previous=newNode;
            incrementSize();
        }
    }

    public void deleteAtIndex(int index) {
        if(index==0)
            deleteFromHead();
        else if(index>0 && index<size){
            Node node=getNode(index);
            if(node.previous!=null){
                node.previous.next=node.next;
            }
            if(node.next!=null){
                node.next.previous=node.previous;
            }else{
                tail=node.previous;
            }
            decrementSize();
        }
    }

    /** Delete element from head of list */
    public void deleteFromHead() {
        if(!isEmpty()){
            Node node=head.next;
            if(node!=null){
                node.previous=null;
            }
            head=node;
            decrementSize();
        }
    }
}
