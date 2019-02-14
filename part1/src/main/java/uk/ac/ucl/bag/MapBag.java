package uk.ac.ucl.bag;

import java.util.ArrayList;
import java.util.HashMap;

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
        for(T element : contents.keySet()){
            if(element.compareTo(value)==0){

            }
        }
    }


}
