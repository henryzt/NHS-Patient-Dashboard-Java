package uk.ac.ucl.bag;

import javax.imageio.IIOException;
import java.io.IOException;

public class MainSaveLoad {
    private BagFactory<String> factory = BagFactory.getInstance();

    private void run() throws BagException{
        factory.setBagClass("LinkedListBag");

        Bag<String> stringBag = factory.getBag();
        stringBag.add("abc");
        stringBag.add("def");
        stringBag.add("def");
        stringBag.add("ghi");

        System.out.println(stringBag.toString());

        try {
            stringBag.saveBagToFile("test.txt");

            stringBag.readFileToBag("test.txt");

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args){
        try {
            new MainSaveLoad().run();
        }catch (BagException e){
            e.printStackTrace();
        }
    }
}
