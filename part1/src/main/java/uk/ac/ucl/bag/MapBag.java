package uk.ac.ucl.bag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapBag<T extends Comparable> extends AbstractBag<T> {




    private int maxSize;
    private HashMap<T, Integer> contents;

    public MapBag() throws BagException{
        this(MAX_SIZE);
    }

    public MapBag(int maxSize) throws BagException{
        if (maxSize > MAX_SIZE){
            throw new BagException("Attempting to create a Bag with size greater than maximum");
        }
        if (maxSize < 1){
            throw new BagException("Attempting to create a Bag with size less than 1");
        }
        this.maxSize = maxSize;
        this.contents = new HashMap<>();
    }


    public void add(T value) throws BagException{
        if(contents.containsKey(value)){
            int valueOccurrence = contents.get(value);
            contents.replace(value,valueOccurrence + 1);
            return;
        }

        if(contents.size() < maxSize){
            contents.putIfAbsent(value,1);
        }else {
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
        return contents.containsKey(value);
    }

    public int countOf(T value) {
        if(this.contains(value)){
            return contents.get(value);
        }
        return 0;
    }

    public void remove(T value)
    {
        if(this.contains(value)){
            int valueOccurrence = contents.get(value);
            contents.replace(value,valueOccurrence - 1);
            if (contents.get(value) == 0)
            {
                contents.remove(value);
            }
        }
    }

    public boolean isEmpty()
    {
        return contents.size() == 0;
    }

    public int size()
    {
        return contents.size();
    }


    private class MapBagUniqueIterator implements Iterator<T>
    {


        private int index = 0;
        HashMap.Entry<T,Integer>[] valueSet;

        public boolean hasNext()
        {

            if (index < contents.size()){
                valueSet = contents.entrySet().toArray(new HashMap.Entry[contents.size()]);
                return true;
            }
            return false;

        }


        public T next()
        {

            return valueSet[index++].getKey();
        }
    }

    /*
      Return an iterator object. Code calling this method will get an object that behaves as an iterator but does not
      need to know the actual class of the object, which is private anyway.
     */
    public Iterator<T> iterator()
    {
        return new MapBagUniqueIterator();
    }

    /*
      This class implements an additional iterator that returns all values in a bag including a value for each copy.
      It is also a nested inner class.
     */
    private class MapBagIterator implements Iterator<T>
    {
        private int index = 0;
        private int count = 0;
        HashMap.Entry<T,Integer>[] valueSet;

        public boolean hasNext()
        {
            valueSet = contents.entrySet().toArray(new HashMap.Entry[0]);

            if (index < contents.size()) {
                if (count < valueSet[index].getValue()) return true;
                if ((count == valueSet[index].getValue()) && ((index + 1) < contents.size())) return true;
            }
            return false;
        }

        public T next()
        {
            if (count < valueSet[index].getValue())
            {
                T value = valueSet[index].getKey();
                count++;
                return value;
            }
            count = 1;
            index++;
            return valueSet[index].getKey();
        }
    }

    public Iterator<T> allOccurrencesIterator()
    {
        return new MapBagIterator();
    }


}
