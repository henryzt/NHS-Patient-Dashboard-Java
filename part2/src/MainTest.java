public class MainTest {

    public static void main(String[] args){
        Patient test = new Patient();
        test.addRecord("FIRST","Test");
        test.addRecord("OK","Test");
        System.out.println(test.get("FIRST"));



        Model model = new Model();

        model.readFromCSV("patients100.csv");
        System.out.println(model.getAllPatients());
        System.out.println(model.getPatientJson(model.getPatientByIndex(0)));

    }

}
