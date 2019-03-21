package uk.ac.ucl.model;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Statistics {
    private List<Patient> patients;
    private List<Integer> age = new ArrayList<>();
    private List<Integer> born = new ArrayList<>();
    private int maxBorn = 0, minBorn = 3000, maxAge = 0, minAge = 1000, averAge,  deceasedCount = 0, ageSum = 0;
    private Map.Entry<Integer,Integer> comAge, comBorn;

    Statistics(List<Patient> patients){
        this.patients = patients;
        calculate();
    }

    private void calculate(){

        for(Patient p : patients){

            int current = getYear(p, "BIRTHDATE");
            int currentAge = getAge(p, p.get("BIRTHDATE"));

            if(!p.get("DEATHDATE").equals("")) {
                deceasedCount++;
            }

            ageSum += currentAge;
            age.add(currentAge);
            born.add(current);

            if(currentAge > maxAge){
                maxAge = currentAge;
            }
            if(currentAge < minAge){
                minAge = currentAge;
            }
            if(current > maxBorn){
                maxBorn = current;
            }
            if(current < minBorn){
                minBorn = current;
            }
        }

        averAge = ageSum / patients.size();
        comAge = getMostCommon(age);
        comBorn = getMostCommon(born);

    }

    public int getAge(Patient p){
        return getAge(p, p.get("BIRTHDATE"));
    }

    private int getAge(Patient p, String birthdate){
        if(!p.get("DEATHDATE").equals("")){
            return Period.between(LocalDate.parse(birthdate), LocalDate.parse(p.get("DEATHDATE"))).getYears();
        }else {
            return Period.between(LocalDate.parse(birthdate), LocalDate.now()).getYears();
        }
    }


    private Map.Entry getMostCommon(List<Integer> list){
        Map<Integer,Integer> count = new HashMap<>();
        for (int i : list){
            if (!count.containsKey(i)) {
                count.put(i, 1);
            }else {
                count.put(i, count.get(i) + 1);
            }
        }

        int max = 0;
        Map.Entry<Integer,Integer> mostCommon = null;
        for(Map.Entry<Integer,Integer> m : count.entrySet()){
            if(m.getValue() > max){
                max = m.getValue();
                mostCommon = m;
            }
        }
        return mostCommon;
    }


    private int getYear(Patient p, String field){
        return Integer.parseInt(p.get(field).split("-")[0]);
    }



    public List<String> getStatisticInfo(){
        List<String> info = new ArrayList<>();
        info.add("This list contain "+ patients.size() + " patients in total");
        info.add("The most common age is "+ comAge.getKey() + ", with " + comAge.getValue() + " patients at this age " );
        info.add("The most common year is "+ comBorn.getKey() + ", where " + comBorn.getValue() + " patients born this year" );
        info.add("The youngest patients is born in "+ maxBorn);
        info.add("The eldest patients is born in "+ minBorn);
        info.add("There are "+ deceasedCount + " deceased patients in the list");
        info.add("The eldest patients is "+ maxAge +" years old");
        info.add("The youngest patients is "+ minAge + " year(s) old");
        info.add("The average age of all patients is "+ averAge );
        info.add("Dashboard made by Henry Zhang - 18007308");
        return info;
    }

}
