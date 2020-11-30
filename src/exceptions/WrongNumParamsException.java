package exceptions;

public class WrongNumParamsException extends Exception {

  private static final long serialVersionUID = 1L;


  public WrongNumParamsException() {}
  
  
  public WrongNumParamsException(String errorMessage) {
    super(errorMessage);
  }
  
  
  public WrongNumParamsException(Throwable cause) {
    super(cause);
  }
}
