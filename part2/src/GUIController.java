import java.util.Collection;
import java.util.List;

public class GUIController {

    private Model model;


    GUIController(){
        model = new Model();
    }

    public void LoadPatients(String filePath){
        model.readFile(filePath);
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

}
