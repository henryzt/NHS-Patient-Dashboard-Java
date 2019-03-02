import java.util.Collection;
import java.util.List;

public class GUIController {

    private Model model;


    GUIController(){
        model = new Model();
    }

    public boolean LoadPatients(String filePath){
        try {
            model.readFile(filePath);
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

}
