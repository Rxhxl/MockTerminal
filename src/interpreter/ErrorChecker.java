package interpreter;

import java.util.List;
import commands.ChangeDirectory;
import commands.Exit;
import commands.MakeDirectory;
import commands.PrintWorkingDirectory;
import exceptions.WrongNumParamsException;

public class ErrorChecker {

  public static boolean checkForErrors(Object command, List<String> tokens)
      throws WrongNumParamsException {
    if (command instanceof Exit)
      return checkExitForErrors(tokens);
    else if (command instanceof MakeDirectory)
      return checkMakeDirectoryForErrors(tokens);
    else if (command instanceof commands.List)
      return checkListForErrors(tokens);
    else if (command instanceof ChangeDirectory)
      return checkChangeDirectoryForErrors(tokens);
    else if (command instanceof PrintWorkingDirectory) 
      return checkPrintWorkingDirectoryForErrors(tokens);
      
    return false;
  }


  private static boolean checkExitForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() > 1)
      throw new WrongNumParamsException();
    return true;
  }


  private static boolean checkMakeDirectoryForErrors(List<String> tokens)
      throws WrongNumParamsException {
    if (tokens.size() < 2)
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkListForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() < 1)
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkChangeDirectoryForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() > 2) 
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkPrintWorkingDirectoryForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() > 1) {
      throw new WrongNumParamsException();
    }
    return true;    
  }
}
