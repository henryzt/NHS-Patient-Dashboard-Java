package uk.ac.ucl.bag;

public class LinkedListBag<T extends Comparable> extends AbstractBag<T> {

    private class Node<T>{
        public T value;
        public int occurrences;
        public Node<T> next;

        public Node(T value, int occurrences, Node<T> next){
            this.value = value;
            this.occurrences = occurrences;
            this.next = next;
            nodeCounts++;
        }

    }

    private int maxSize;
    private int nodeCounts;
    Node<T> head = null;

    public LinkedListBag() throws BagException
    {
        this(MAX_SIZE);
    }

    public LinkedListBag(int maxSize) throws BagException
    {
        if (maxSize > MAX_SIZE)
        {
            throw new BagException("Attempting to create a Bag with size greater than maximum");
        }
        if (maxSize < 1)
        {
            throw new BagException("Attempting to create a Bag with size less than 1");
        }
        this.nodeCounts = 0;
        this.maxSize = maxSize;
    }


    public void add(T value) throws BagException{
        if(head == null){
            head = new Node<>(value,1,null);
        }

        Node<T> current = head;

        for(int i = 0; i < nodeCounts; i++){
            if(current.value.compareTo(value) == 0){
                current.occurrences++;
                return;
            }
            current = current.next;
        }

        if (nodeCounts < maxSize)
        {
            current.next = new Node<>(value,1,null);
        }
        else
        {
            throw new BagException("Bag is full");
        }
    }


    public void addWithOccurrences(T value, int occurrences) throws BagException
    {
        for (int i = 0 ; i < occurrences ; i++)
        {
            add(value);
        }
    }


    public boolean contains(T value) {
        Node<T> current = head;

        for(int i = 0; i < nodeCounts; i++){
            if(current.value.compareTo(value) == 0){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int countOf(T value)
    {
        Node<T> current = head;

        for(int i = 0; i < nodeCounts; i++){
            if(current.value.compareTo(value) == 0){
                return current.occurrences;
            }
            current = current.next;
        }
        return 0;
    }




}
