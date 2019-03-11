import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private List<Patient> patients;
    Statistics(List<Patient> patients){
        this.patients = patients;
    }

    private String getMax(String field){
        int max = 0;
        for(Patient p : patients){
            int current = Integer.parseInt(p.get(field).split("-")[0]);
            if(current > max){
                max = current;
            }
        }
        return String.valueOf(max);
    }


    public List<String> getStatisticInfo(){
        List<String> info = new ArrayList<>();
        info.add("This list contain "+ patients.size() + " patients in total.");
        info.add("The youngest patients is born in "+ getMax("BIRTHDATE"));
        info.add("Dashboard developed by Henry Zhang");
        return info;
    }

}
