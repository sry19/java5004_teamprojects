package model.optiondata;

import java.util.ArrayList;

public class RequiredOptions {
  public static ArrayList<String> getRequired() {
    ArrayList<String> required = new ArrayList<>();
    required.add("--csv-file");  //and the parameter after??????
    required.add("--add-todo");
    required.add("--todo-text"); //and the parameter
    required.add("--complete-todo"); //and the parameter
    required.add("--display");

    return required;
  }

}