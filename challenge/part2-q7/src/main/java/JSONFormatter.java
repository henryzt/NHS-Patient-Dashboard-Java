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
        List<Patient> patients = new ArrayList<>();
        if(patientJson == null){
            return null;
        }
        for(String json : patientJson){
            String[] details = json.split(" *, *");
            Patient p = new Patient();
            for(String detail : details){
                String[] hashPair = parseOneStringEntry(detail);
                if(hashPair == null){return null;}
                p.addRecord(hashPair[0],hashPair[1]);
            }
            patients.add(p);
        }
        return patients;
    }

    private String[] parseAllPatientJson(String allPatientJson){
        //TODO get only patient array
        allPatientJson = allPatientJson.replaceAll("\n","");
        allPatientJson = allPatientJson.replaceAll("^\\{|}$",""); //replace all curly brackets?
        Pattern p = Pattern.compile("\\[.*\\]"); //match json array
        Matcher m = p.matcher(allPatientJson);
        if(!m.find()){return null;}
        String content = m.group();
        content = content.replaceAll("^\\[|\\]$",""); //replace all square brackets

        return content.split("} *, *\\{");
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
