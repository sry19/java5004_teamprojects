package model.filter1;

import controller.commandlineparser.ICommandLine;
import java.util.ArrayList;
import model.Todo;

public class TodoFilterStash extends FilterStash<Todo> {

  public TodoFilterStash(ICommandLine commandLine) {
    super(commandLine);
  }

  public ArrayList<Todo> filter(ArrayList<Todo> todoArrayList) {
    for (Filter filter: this.filters) {
      todoArrayList = filter.filter(todoArrayList);
    }
    return todoArrayList;
  }
}
