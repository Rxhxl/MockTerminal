package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import commands.ChangeDirectory;
import commands.Exit;
import commands.History;
import commands.MakeDirectory;
import commands.PrintWorkingDirectory;
import commands.Tree;
import exceptions.InvalidParamsException;
import exceptions.WrongNumParamsException;
import filesystem.FileSystem;

public class Interpreter {

  private List<String> tokens;
  private static HashMap<String, Object> commands;
  private FileSystem fileSystem;
  private History history; // Need history here in order to keep adding to it


  public Interpreter(FileSystem fileSystem) {
    tokens = new ArrayList<String>();
    this.fileSystem = fileSystem;
    this.history = new History();
    generateCommands();
  }


  /**
   * Determines which command the user wanted to run and calls the corresponding method. Also let's
   * used know if their input was invalid.
   * 
   * @param userInput String of input that the user has entered
   */
  public void interpret(String userInput) {
    tokenizeUserInput(userInput);
    Object command = commands.get(tokens.get(0));
    history.addInput(tokens.get(0));
    
    try {
      if (command instanceof Exit && ErrorChecker.checkForErrors(command, tokens)) {
        Exit.class.cast(command).run(tokens);
      } else if (command instanceof MakeDirectory && ErrorChecker.checkForErrors(command, tokens)) {
        MakeDirectory.class.cast(command).run(tokens);
      } else if (command instanceof commands.List && ErrorChecker.checkForErrors(command, tokens)) {
        commands.List.class.cast(command).run(tokens);
      } else if (command instanceof ChangeDirectory && ErrorChecker.checkForErrors(command, tokens)) {
        ChangeDirectory.class.cast(command).run(tokens);
      } else if (command instanceof PrintWorkingDirectory && ErrorChecker.checkForErrors(command, tokens)) {
        PrintWorkingDirectory.class.cast(command).run(tokens);
      } else if (command instanceof History && ErrorChecker.checkForErrors(command, tokens)) {
        History.class.cast(command).run(tokens);
      } else if (command instanceof Tree && ErrorChecker.checkForErrors(command, tokens)) {
        Tree.class.cast(command).run(tokens);
      }
      else {
        System.out.println("You have entered an invalid command");
      }
    } catch (WrongNumParamsException e) {
      ErrorHandler.handleWrongNumParamsException(tokens);
    } catch (InvalidParamsException e) {
      ErrorHandler.handleInvalidParamsException(tokens);
    }
  }


  /**
   * Splits the users input into interpreter readable tokens that can determine what command to run.
   * 
   * @param userInput String of input that the user has entered
   */
  private void tokenizeUserInput(String userInput) {
    tokens = Arrays.asList(userInput.trim().split("\\s+"));
  }


  /**
   * Populates the commands hash map with all the possible commands that the user might want to use.
   */
  private void generateCommands() {
    commands = new HashMap<String, Object>();
    commands.put("exit", new Exit());
    commands.put("mkdir", new MakeDirectory(this.fileSystem));
    commands.put("ls", new commands.List(this.fileSystem));
    commands.put("cd", new ChangeDirectory(this.fileSystem));
    commands.put("pwd", new PrintWorkingDirectory(this.fileSystem));
    commands.put("history", history);
    commands.put("tree", new Tree(this.fileSystem));
  }
}
