package uk.ac.ucl.bag;

/**
 * This class implements methods common to all concrete bag implementations
 * but does not represent a complete bag implementation.<br />
 *
 * New bag objects are created using a BagFactory, which can be configured in the application
 * setup to select which bag implementation is to be used.
 */
import java.util.Iterator;

public abstract class AbstractBag<T extends Comparable> implements Bag<T>
{
  public Bag<T> createMergedAllOccurrences(Bag<T> b) throws BagException {
    Bag<T> result = BagFactory.getInstance().getBag();
    for (T value : this)
    {
      result.addWithOccurrences(value, this.countOf(value));
    }
    for (T value : b)
    {
      result.addWithOccurrences(value, b.countOf(value));
    }
    return result;
  }

  public Bag<T> createMergedAllUnique(Bag<T> b) throws BagException {
    Bag<T> result = BagFactory.getInstance().getBag();
    for (T value : this)
    {
      if (!result.contains(value)) result.add(value);
    }
    for (T value : b)
    {
      if (!result.contains(value)) result.add(value);
    }
    return result;
  }

  public String toString()
  {

    boolean first = true;
    String result;
    result = "[";
    for (T value : this){

      if (!first) { result += " , "; }
      first = false;

      result += value;
      result += " : ";
      result += this.countOf(value);


    }
    result += "]";
    return result;
  }


  public void removeAllCopies(){

    for (T object : this) {
      int count = this.countOf(object);
      for (int i = 0; i < count - 1; i++) {
        this.remove(object);
      }
    }

  }


  public Bag<T> subtract(Bag<T> bagForSubtract) throws BagException{
      Bag<T> result = BagFactory.getInstance().getBag();

      for (T object : this) {
          int newCount = this.countOf(object) - bagForSubtract.countOf(object);
          if(newCount > 0){
              result.addWithOccurrences(object,newCount);
          }

      }


      return result;
  }




}
