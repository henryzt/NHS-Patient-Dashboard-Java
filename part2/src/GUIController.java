import java.util.ArrayList;
import java.util.List;

public class GUIController {

    private Model model;
    private List<String> patientNameList = null;
    private List<Patient> searchResult = new ArrayList<>();
    private String patientsJson = null;

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
        if(patientNameList == null) {
            patientNameList = model.getNameArray();
        }
        return patientNameList;
    }

    public String getPatientJson(int index){
        return model.getPatientJson(model.getPatientByIndex(index));
    }

    public String getAllJson(){
        if(patientsJson == null){
            patientsJson = model.getAllPatientsJson();
        }
        return patientsJson;
    }

    public boolean saveJsonTo(String path){
        return model.saveJsonTo(path, getAllJson());
    }

    //check if the patients csv is loaded correctly (if FIRST & LAST exists)
    public boolean checkLoadedPatientName(){
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

    public List<String> getSearchResultNames() {
        if(searchResult != null) {
            return model.getNameArray(searchResult);
        }
        return null;
    }



}
