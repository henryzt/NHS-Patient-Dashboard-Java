public class MainTest {

    public static void main(String[] args){
        Patient test = new Patient();
        test.addRecord("FIRST","Test");
        test.addRecord("OK","Test");
        System.out.println(test.get("FIRST"));
    }

}
