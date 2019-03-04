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

    public String getAllPatientsJson(){
        return json.getAllPatientJson(patients);
    }

    //for search results
    public String getAllPatientsJson(List<Patient> list){
        return json.getAllPatientJson(list);
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

    //for search results
    public Patient getPatientByIndex(List<Patient> list, int i){
        return list.get(i);
    }

    public List<String> getNameArray(){
        List<String> names = new ArrayList<>();
        for(Patient p : patients){
            names.add(getName(p));
        }

        return names;
    }

    //for search results
    public List<String> getNameArray(List<Patient> list){
        List<String> names = new ArrayList<>();
        for(Patient p : list){
            names.add(getName(p));
        }

        return names;
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


    public List<Patient> search(String target){
        List<Patient> results = new ArrayList<>();
        for(Patient p : patients){
            if(p.findRecord(target)){
                results.add(p);
            }
        }
        if(results.size() == 0){
            return null;
        }
        return results;
    }



}
