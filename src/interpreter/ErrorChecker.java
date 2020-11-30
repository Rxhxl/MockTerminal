package interpreter;

import java.util.List;
import commands.ChangeDirectory;
import commands.Exit;
import commands.History;
import commands.MakeDirectory;
import commands.Popd;
import commands.PrintWorkingDirectory;
import commands.Pushd;
import commands.Remove;
import commands.Tree;
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
    else if (command instanceof History)
      return checkHistoryForErrors(tokens);
    else if (command instanceof Tree)
      return checkTreeForErrors(tokens);
    else if (command instanceof Remove)
      return checkRemoveForErrors(tokens);
    else if (command instanceof Popd)
      return checkPopdForErrors(tokens);
    else if (command instanceof Pushd)
      return checkPushdForErrors(tokens);
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
    if (tokens.size() != 2) 
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkPrintWorkingDirectoryForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() > 1) {
      throw new WrongNumParamsException();
    }
    return true;    
  }
  
  
  private static boolean checkHistoryForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() > 2)
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkTreeForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() != 1) 
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkRemoveForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() != 2) 
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkPopdForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() != 1) 
      throw new WrongNumParamsException();
    return true;
  }
  
  
  private static boolean checkPushdForErrors(List<String> tokens) throws WrongNumParamsException {
    if (tokens.size() != 2)
      throw new WrongNumParamsException();
    return true;
  }
}
