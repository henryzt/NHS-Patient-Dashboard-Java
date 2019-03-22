package uk.ac.ucl.bag;

import java.io.IOException;

//For testing file IO functions, string / double type etc

public class MainSaveLoadTest {
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
            new MainSaveLoadTest().run();
        }catch (BagException e){
            e.printStackTrace();
        }
    }
}
