import java.util.List;

public class MainTest {

    public static void main(String[] args){
        Patient test = new Patient();
        test.addRecord("FIRST","Test");
        test.addRecord("OK","Test");
        System.out.println(test.get("FIRST"));

        List<Patient> patients = new ReadCSV().readCSV("patients100.csv");
//        for(Patient p : patients){
//            System.out.println(p.get("FIRST"));
//        }

        System.out.println(new JSONFormatter().getJson(patients.get(0)));

    }

}
