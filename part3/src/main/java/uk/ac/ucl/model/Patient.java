package uk.ac.ucl.model;
import java.util.LinkedHashMap;

public class Patient {
    private LinkedHashMap<String,String> entry;

    Patient(){
        entry = new LinkedHashMap<>();
    }

    public void addRecord(String field, String value){
        entry.putIfAbsent(field,value);
    }

    public String get(String field){
        return entry.get(field);
    }

    public void set(String field, String value){
        entry.replace(field,value);
    }

    public String[] getFields(){
        return entry.keySet().toArray(new String[0]);
    }

    public boolean findRecord(String target){
        for(var m : entry.entrySet()){
            if(m.getValue().toLowerCase().contains(target.toLowerCase())){
                return true;
            }
        }
        return false;
    }

}
