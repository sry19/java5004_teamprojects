package model.filter1;

import java.util.ArrayList;
import model.Todo;

public interface IFilter {

  ArrayList<Todo> filter(ArrayList<Todo> itemList);

}
