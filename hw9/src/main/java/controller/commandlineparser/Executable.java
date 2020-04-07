package controller.commandlineparser;

/**
 * Executable define an action where the class should take a ICommandLine ADT and execute.
 */
public interface Executable {

  /**
   * Execute according to ICommandLine.
   *
   * @param iCommandLine the provided ICommandLine.
   * @throws Exception if anything goes wrong.
   */
  void execute(ICommandLine iCommandLine) throws Exception;
}
