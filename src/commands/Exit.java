package commands;

import java.util.List;

public class Exit implements Command {

  @Override
  public void run(List<String> tokens) {
    System.out.println("Program Terminated");
    System.exit(0); 
  }
  
  
  public String toString() {
    return "exit - Quit the program";
  }
}
