import java.util.List;

public class GUIController {

    private Model model;


    GUIController(){
        model = new Model();
    }

    public boolean LoadPatients(String filePath){
        try {
            model.readFromCSV(filePath);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getPatientNames(){
        return model.getNameArray();
    }

    public String getPatientJson(int index){
        return model.getPatientJson(model.getPatientByIndex(index));
    }

    public String getAllJson(){
        return model.getAllPatients();
    }

    public boolean saveJsonTo(String path){
        return model.saveJsonTo(path, getAllJson());
    }

    //check if the patients csv is loaded correctly (if FIRST & LAST exists)
    public boolean checkLoadedPatientName(){
        Patient p = model.getPatientByIndex(0);
        return (p.get("FIRST") ==null || p.get("LAST") ==null);
    }

}
