import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Patient> patients;
    private ReadCSV csv = new ReadCSV();
    private JSONFormatter json = new JSONFormatter();

    Model(){
        patients = new ArrayList<>();
    }

    public void readFromCSV(String path){
        patients = csv.readCSV(path);

    }

    public String getAllPatients(){
        return json.getAllPatientJson(patients);
    }


    public String getPatientJson(Patient p){
        return json.getSinglePatientJson(p);
    }

    public String getName(Patient p){
        return p.get("FIRST") + " " + p.get("LAST");
    }

    public String getId(Patient p){
        return p.get("ID");
    }

    public Patient getPatientByIndex(int i){
        return patients.get(i);
    }

    public List<String> getNameArray(){
        List<String> names = new ArrayList<>();
        for(Patient p : patients){
            names.add(p.get("FIRST") + " " + p.get("LAST"));
        }

        return names;
    }

    public String[] getIdArray(){
        List<String> ids = new ArrayList<>();
        for(Patient p : patients){
            ids.add(p.get("ID"));
        }

        return ids.toArray(String[]::new);
    }


    public boolean saveJsonTo(String path, String json){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(json);
            writer.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }



}
