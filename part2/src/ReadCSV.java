import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    ReadCSV(){

    }



    private List<String> readFile(String fileName) {

        List<String> content = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                content.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;

    }

    private String[] separateComma(String row){
        return row.split(",");
    }



    public List<Patient> readCSV(String filePath){

        List<Patient> patients = new ArrayList<>();
        List<String> content = readFile(filePath);
        String[] fields = {};

        int current = 0;
        for(String row : content){
            String[] entry = separateComma(row);

            if(current == 0){
                fields = entry;
            }else{

                Patient p = new Patient();
                int i = 0;
                for(String value : entry) {
                    p.addRecord(fields[i],value);
                    i++;
                }
                patients.add(p);

            }

            current++;
        }
        return patients;
    }



}
