package uk.ac.ucl.bag;

import java.util.Iterator;

public class LinkedListBag<T extends Comparable> extends AbstractBag<T> {

    private int maxSize;
    private int nodeCounts;
    private Node<T> head = null;


    public LinkedListBag() throws BagException {
        this(MAX_SIZE);
    }

    public LinkedListBag(int maxSize) throws BagException {
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


    private Node<T> findNode(T value){
        Node<T> current = head;

        for(int i = 0; i < nodeCounts; i++){
            if(current.value.compareTo(value) == 0){
                return current;
            }
            if(current.next == null){
                break;
            }
            current = current.next;
        }
        return null;
    }


    private Node<T> findLastNode(){
        Node<T> current = head;
        while(current.next != null){
            current = current.next;
        }

        return current;
    }




    public void add(T value) throws BagException{
        if(head == null){
            head = new Node<>(value,0,null);
        }

        Node<T> target = findNode(value);

        if(target != null){
            target.occurrences++;
            return;
        }else {
            target = findLastNode();
        }


        if (nodeCounts < maxSize) {
            target.next = new Node<>(value,1,null);
        }
        else {
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
        if(findNode(value)!=null){
            return true;
        }
        return false;
    }

    public int countOf(T value)
    {
        Node target = findNode(value);
        if(target!= null){
            return target.occurrences;
        }
        return 0;
    }

    public void remove(T value)
    {
        Node<T> current = head;

        for(int i = 0; i < nodeCounts; i++){
            if(current.next.value.compareTo(value) == 0){
                Node<T> toRemove = current.next;
                toRemove.occurrences--;
                if(toRemove.occurrences == 0) {
                    current.next = toRemove.next;
                    nodeCounts--;
                }
                return;
            }
            current = current.next;
        }
    }


    public boolean isEmpty()
    {
        return nodeCounts == 0;
    }

    public int size()
    {
        return nodeCounts;
    }



    private class LinkedListBagUniqueIterator implements Iterator<T>
    {
        private Node<T> current = new Node<>(null,0,head);

        public boolean hasNext() {
            return (current.next != null);
        }

        public T next(){
            current = current.next;
            return current.value;
        }
    }

    public Iterator<T> iterator()
    {
        return new LinkedListBagUniqueIterator();
    }




    private class LinkedListBagIterator implements Iterator<T>
    {
        private Node<T> current = head;
        private int count = 0;

        public boolean hasNext()
        {
            if (current!=null) {
                if (count < current.occurrences) return true;
                if ((count == current.occurrences) && (current.next!=null)) return true;
            }
            return false;
        }

        public T next()
        {
            if (count < current.occurrences)
            {
                T value = current.value;
                count++;
                return value;
            }
            count = 1;
            current = current.next;
            return current.value;
        }
    }

    public Iterator<T> allOccurrencesIterator()
    {
        return new LinkedListBagIterator();
    }


}
