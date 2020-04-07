//package model.filter;
//
//import java.util.ArrayList;
//import model.Todo;
//
//public class Main {
//  public static void main(String[] args) {
//    ArrayList<Todo> todos = new ArrayList<>();
//    ArrayList<String> categories = new ArrayList<>();
//    categories.add("work");
//    categories.add("business");
//
//    FilterSettings both = new FilterSettings.Builder().incompleteTodo().selectCategory(categories).build();
//    FilterPlatform platform = new FilterPlatform(both);
//    platform.filter(todos);
//
//    FilterSettings onlyOne = new FilterSettings.Builder().incompleteTodo().build();
//    FilterPlatform platform1 = new FilterPlatform(both);
//    platform.filter(todos);
//
//    FilterSettings only12 = new FilterSettings.Builder().selectCategory(categories).build();
//    FilterPlatform platform3 = new FilterPlatform(both);
//    platform.filter(todos);
//  }
//}
