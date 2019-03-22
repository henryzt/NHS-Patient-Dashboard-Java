package uk.ac.ucl.model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Patient> patients;
    private ReadCSV csv = new ReadCSV();

    public Model(){
        patients = new ArrayList<>();
    }

    public void readFromCSV(String path){
        patients = csv.readCSV(path);
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


    public List<Patient> getPatients() {
        return patients;
    }

    public Patient getPatientById(String id){
        List<Patient> p = search(id);
        if(p == null){
            return null;
        }

        return p.get(0);
    }
}
