import java.util.ArrayList;
import java.util.List;

public class JSONFormatter {

    JSONFormatter(){

    }

    public String getSinglePatientJson(Patient patient){
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        String[] fields = patient.getFields();

        for(String field : fields){
            builder.append('"');
            builder.append(field);
            builder.append("\" : \"");
            builder.append(patient.get(field));
            builder.append("\",\n");
        }

        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("}");

        return builder.toString();

    }


    private String getJsonArray(String[] jsons){
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(String json : jsons){
            builder.append(json);
            builder.append(",\n");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("]");

        return builder.toString();
    }


    public String getAllPatientJson(List<Patient> patients){

        ArrayList<String> patientsArray = new ArrayList<>();
        for(Patient p : patients){
            patientsArray.add(getSinglePatientJson(p));
        }

        String patientsJson = getJsonArray(patientsArray.toArray(new String[0]));

        return "{\n\"patients\" : " + patientsJson + "\n}";


    }


}
