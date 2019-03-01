import java.util.List;

public class MainTest {

    public static void main(String[] args){
        Patient test = new Patient();
        test.addRecord("FIRST","Test");
        test.addRecord("OK","Test");
        System.out.println(test.get("FIRST"));



        Model model = new Model();

        model.readFile("patients100.csv");
        System.out.println(model.getAllPatients());
        System.out.println(model.getPatient(model.getPatientByIndex(0)));

    }

}
