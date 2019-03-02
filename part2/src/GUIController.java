import java.util.Collection;
import java.util.List;

public class GUIController {

    private Model model;


    GUIController(){
        model = new Model();
    }

    public List<String> getPatientList(String filePath){
        model.readFile(filePath);
//        System.out.println(model.getNameArray()[0]);
        return model.getNameArray();
    }

}
