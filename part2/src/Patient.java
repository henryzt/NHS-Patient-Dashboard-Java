import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Patient {
    private HashMap<String,String> entry;

    Patient(){
        entry = new HashMap<>();
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
            if(target.equals(m.getValue())){
                return true;
            }
        }
        return false;
    }

}
