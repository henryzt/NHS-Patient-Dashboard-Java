import java.io.*;
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

    public boolean readFromJson(String path){
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                builder.append(currentLine);
                builder.append('\n');
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String content =  builder.toString();

        List<Patient> p = json.getPatientFromJson(content);
        if(p == null){
            return false;
        }
        patients = p;
        return true;

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
            names.add(getName(p));
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
