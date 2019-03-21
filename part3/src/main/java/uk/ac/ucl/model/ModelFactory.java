package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ModelFactory
{
  private static Model model;
  private static Statistics statistics;

  public static Model getModel() {
    if (model == null) {
      model = new Model();
      model.readFromCSV("patients/patients10000.csv");
      statistics = new Statistics(model.getPatients());
    }
    return model;
  }

  public static int getPatientAge(Patient p) {
    if (model == null) {
      getModel();
    }
    return statistics.getAge(p);
  }

  public static List<String> getStatistics(){
    if (model == null) {
      getModel();
    }
    return statistics.getStatisticInfo();
  }

}
