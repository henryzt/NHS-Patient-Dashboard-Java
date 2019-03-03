import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<Patient> getPatientFromJson(String allPatientJson){
        String[] patientJson = parseAllPatientJson(allPatientJson);
        for(String json : patientJson){
            System.out.println(json);
        }
        return null;
    }

    private String[] parseAllPatientJson(String allPatientJson){
        allPatientJson = allPatientJson.replaceAll("\n",""); //delete curly bracket at both side
        allPatientJson = allPatientJson.replaceAll("^ *\\{|} *$",""); //delete curly bracket at both side
        String content = allPatientJson.split(" *: *")[1]; //get array content (second part)
        content = content.replaceAll("^ *[|] *$",""); //delete square bracket for array
        return content.split(",");
    }

    private String[] parseOneStringEntry(String entry){
        Pattern p = Pattern.compile("\"([^:]*)\"");
        Matcher m = p.matcher(entry);

        String[] res = {"",""};
        if(!m.find()){return null;}
        res[0] = m.group(1);           //entry name
        if(!m.find()){return null;}
        res[1] = m.group(1);          //entry content

        return res;
    }



}
