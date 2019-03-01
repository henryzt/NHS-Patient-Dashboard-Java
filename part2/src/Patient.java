import java.util.ArrayList;
import java.util.HashMap;

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


}
