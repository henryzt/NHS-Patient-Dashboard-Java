package uk.ac.ucl.bag;

/**
 * This class implements methods common to all concrete bag implementations
 * but does not represent a complete bag implementation.<br />
 *
 * New bag objects are created using a BagFactory, which can be configured in the application
 * setup to select which bag implementation is to be used.
 */
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

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

//TODO USE JSON
  public void saveBagToFile(String fileName) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    writer.write(this.toString());
    writer.close();

  }

  public void readFileToBag(String fileName) throws IOException{

    StringBuilder builder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String currentLine;
      while ((currentLine = reader.readLine()) != null) {
        builder.append(currentLine);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    String content =  builder.toString();



    content = content.replaceAll(" |\\[|\\]","");
    String[] entries = content.split(",");
    for(String entryComb : entries){
        String[] entry = entryComb.split(":");
        try {
            this.addWithOccurrences((T) entry[0], Integer.parseInt(entry[1]));
        }catch (BagException e){
            e.printStackTrace();
        }
    }

//    System.out.println(content);
  }


}
