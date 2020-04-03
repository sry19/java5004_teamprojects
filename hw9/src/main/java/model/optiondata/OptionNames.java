package model;

import java.util.HashMap;

//but what about <> after option, such as --due <due date>?
public class OptionNames {
  //private static HashMap<String, String> matches  = new HashMap<>();  //or Hashmap<T, T> ?

  public static HashMap<String, String> getMap() {
    HashMap<String, String> matches  = new HashMap<>();
    matches.put("--csv-file  regular expression", "--csv-file"); //what about the file path? description?
    matches.put("--add-todo", "--add-todo");

    return matches;
  }

  //make it more friendly
  //put in one big file and attach to command line parser

}