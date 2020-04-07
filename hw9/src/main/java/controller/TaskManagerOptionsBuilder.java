package controller;

import controller.commandlineparser.Option;
import controller.commandlineparser.Options;
import controller.commandlineparser.exceptions.InvalidSplitterException;
import controller.commandlineparser.exceptions.OptionExistedException;

/**
 * An Options Builder for our application, which uses the general commandlineparser package we
 * wrote. This defines all the options we use in this particular application. We can modify it any
 * time in this class.
 */
public class TaskManagerOptionsBuilder extends Options {

  /**
   * Build the options we need for task manager.
   *
   * @return the Options object.
   * @throws InvalidSplitterException if the argSplitter is invalid.
   * @throws OptionExistedException   if the Options already existed in the container.
   */
  public static Options build() throws InvalidSplitterException, OptionExistedException {
    Option option1 = new Option.Builder(OptionConstants.CSV_FILE)
        .addDescription(OptionConstants.CSV_FILE_DES)
        .addRequired(true).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CSV_FILE_ARG_NAME)
        .build();

    Option option2 = new Option.Builder(OptionConstants.ADD_TODO)
        .addDescription(OptionConstants.ADD_TODO_DES)
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{OptionConstants.TODO_TEXT})
        .build();

    Option option3 = new Option.Builder(OptionConstants.TODO_TEXT)
        .addDescription(OptionConstants.TODO_TEXT_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.TODO_TEXT_ARG_NAME)
        .addDependencies(new String[]{OptionConstants.ADD_TODO})
        .build();

    Option option4 = new Option.Builder(OptionConstants.COMPLETED)
        .addDescription(OptionConstants.COMPLETED_DES)
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{OptionConstants.ADD_TODO})
        .build();

    Option option5 = new Option.Builder(OptionConstants.DUE)
        .addDescription(OptionConstants.DUE_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.DUE_ARG_NAME)
        .addDependencies(new String[]{OptionConstants.ADD_TODO})
        .build();

    Option option6 = new Option.Builder(OptionConstants.PRIORITY)
        .addDescription(OptionConstants.PRIORITY_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.PRIORITY_ARG_NAME)
        .addDependencies(new String[]{OptionConstants.ADD_TODO})
        .build();

    Option option7 = new Option.Builder(OptionConstants.CATEGORY)
        .addDescription(OptionConstants.CATEGORY_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.CATEGORY_ARG_NAME)
        .addDependencies(new String[]{OptionConstants.ADD_TODO})
        .build();

    Option option8 = new Option.Builder(OptionConstants.COMPLETE_TODO)
        .addDescription(OptionConstants.COMPLETE_TODO_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(true)
        .addArgSplitter(OptionConstants.ARG_SPLITTER)
        .addArgName(OptionConstants.COMPLETE_TODO_ARG_NAME)
        .build();

    Option option9 = new Option.Builder(OptionConstants.DISPLAY)
        .addDescription(OptionConstants.DISPLAY_DES)
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .build();

    Option option10 = new Option.Builder(OptionConstants.SHOW_INCOMPLETE)
        .addDescription(OptionConstants.SHOW_INCOMPLETE_DES)
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{OptionConstants.DISPLAY})
        .build();

    Option option11 = new Option.Builder(OptionConstants.SHOW_CATEGORY)
        .addDescription(OptionConstants.SHOW_CATEGORY_DES)
        .addRequired(false).addHasSubArg(true).addHasSubArgs(false)
        .addArgName(OptionConstants.SHOW_CATEGORY_ARG_NAME)
        .addDependencies(new String[]{OptionConstants.DISPLAY})
        .build();

    Option option12 = new Option.Builder(OptionConstants.SORT_BY_DATE)
        .addDescription(OptionConstants.SORT_BY_DATE_DES)
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{OptionConstants.DISPLAY})
        .build();

    Option option13 = new Option.Builder(OptionConstants.SORT_BY_PRIORITY)
        .addDescription(OptionConstants.SORT_BY_PRIORITY_DES)
        .addRequired(false).addHasSubArg(false).addHasSubArgs(false)
        .addDependencies(new String[]{OptionConstants.DISPLAY})
        .build();

    Options options = new Options();
    options.addOption(option1);
    options.addOption(option2);
    options.addOption(option3);
    options.addOption(option4);
    options.addOption(option5);
    options.addOption(option6);
    options.addOption(option7);
    options.addOption(option8);
    options.addOption(option9);
    options.addOption(option10);
    options.addOption(option11);
    options.addOption(option12);
    options.addOption(option13);
    return options;
  }
}
