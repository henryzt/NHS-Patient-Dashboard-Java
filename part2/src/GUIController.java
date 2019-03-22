import java.util.ArrayList;
import java.util.List;


public class GUIController {

    private Model model;
    private Statistics statistics;
    private List<String> patientNameList = null;
    private List<Patient> searchResult = null;
    private String patientsJson = null;
    private int sIndex = 0;
    private List<String> sInfo;

    public final int FILE_CSV = 0;
    public final int FILE_JSON = 1;


    GUIController(){
        model = new Model();
    }

    public boolean LoadPatients(String filePath, int method){
        patientsJson = null;
        patientNameList = null;
        try {
            if(method == FILE_CSV) {
                model.readFromCSV(filePath);
            }else if(method == FILE_JSON){
                return model.readFromJson(filePath);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getPatientNames(){
        if(searchResult != null){
            //prioritise search result display
            return model.getNameArray(searchResult);
        }
        if(patientNameList == null) {
            patientNameList = model.getNameArray();
        }
        return patientNameList;
    }

    public String getPatientJson(int index){
        if(searchResult != null){
            return model.getPatientJson(model.getPatientByIndex(searchResult,index));
        }
        return model.getPatientJson(model.getPatientByIndex(index));
    }

    public String getAllJson(){
        if(searchResult != null){
            return model.getAllPatientsJson(searchResult);
        }
        if(patientsJson == null){
            patientsJson = model.getAllPatientsJson();
        }
        return patientsJson;
    }

    public boolean saveJsonTo(String path){
        return model.saveJsonTo(path, getAllJson());
    }


    public boolean checkLoadedPatientName(){
        //check if the patients csv is loaded correctly (if FIRST & LAST exists)
        Patient p = model.getPatientByIndex(0);
        return (p.get("FIRST") ==null || p.get("LAST") ==null);
    }

    public boolean searh(String target){
        searchResult = model.search(target);
        if(searchResult == null){
            return false;
        }

        return true;
    }

    public void clearSearch(){
        searchResult = null;
    }


    public void getStatistics(){
        statistics = new Statistics(model.getPatients());
        sInfo = statistics.getStatisticInfo();
        sIndex = -1;
    }

    public String getNextStatistic(){
        if(sInfo == null){
            return "Load patient file to begin";
        }

        sIndex ++;
        if(sIndex >= sInfo.size()){
            sIndex = 0;
        }
        return sInfo.get(sIndex);
    }

    public void clearStatistics(){
        sInfo = new ArrayList<>();
        sInfo.add("Statistics not available");
    }

    public String getAllStats(){
        if(sInfo == null){
            return "Load patient file to begin";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Statistics:\n");
        for(String info : sInfo){
            builder.append(info);
            builder.append("\n");
        }

        return builder.toString();
    }



}
