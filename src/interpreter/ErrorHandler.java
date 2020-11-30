package interpreter;

import java.util.List;

/**
 * This class is responsible for providing a relevant message to the user
 * depending one what type of error they may have had with their command. 
 *
 */
public class ErrorHandler {

  /**
   * Prints an error message to user if WrongNumParamsException is thrown
   * 
   * @param tokens  the tokens that the user has inputed
   */
  public static void handleWrongNumParamsException(List<String> tokens) {
    System.out.println("You have entered the incorrect number of "
        + "parameters for the command \""
        + tokens.get(0) + "\".");
  }
  
  
  /**
   * Prints an error message to user if InvalidParamsException is thrown
   * 
   * @param tokens  the tokens that the user has inputed
   */
  public static void handleInvalidParamsException(List<String> tokens) {
    System.out.println("You have entered some invalid parameters for the "
        + "command \""
        + tokens.get(0) + "\".\nOnly those parameters that were valid up"
        + " until an invalid input were executed.");
  }
}
