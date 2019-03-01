package uk.ac.ucl.bag;

import javax.imageio.IIOException;
import java.io.IOException;

public class MainSaveLoad {
    private BagFactory<String> stringFactory = BagFactory.getInstance();
    private BagFactory<Double> doubleFactory = BagFactory.getInstance();

    private void run() throws BagException{
        stringFactory.setBagClass("LinkedListBag");
        doubleFactory.setBagClass("LinkedListBag");

        Bag<String> stringBag = stringFactory.getBag();
        stringBag.add("abc");
        stringBag.add("def");
        stringBag.add("def");
        stringBag.add("ghi");

        Bag<Double> doubleBag = doubleFactory.getBag();
        doubleBag.add(1.3);
        doubleBag.add(5.4);
        doubleBag.add(7.533);
        doubleBag.add(5.4);
        doubleBag.addWithOccurrences(6.66,6);

        System.out.println(doubleBag.toString());

        try {

            doubleBag.saveBagToFile("test.txt");

            Bag<Double> readBag = doubleFactory.getBag();
            readBag.readFileToBag("test.txt");
            System.out.println(readBag.toString());

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
