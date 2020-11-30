package exceptions;

public class InvalidParamsException extends Exception {
  
  private static final long serialVersionUID = 1L;


  public InvalidParamsException() {}
  
  
  public InvalidParamsException(String errorMessage) {
    super(errorMessage);
  }
  
  
  public InvalidParamsException(Throwable cause) {
    super(cause);
  }
}
