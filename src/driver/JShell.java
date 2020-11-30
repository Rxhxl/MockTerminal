package driver;

import java.util.Scanner;
import filesystem.FileSystem;
import interpreter.Interpreter;

public class JShell {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FileSystem fileSystem = new FileSystem();
    Interpreter interpreter = new Interpreter(fileSystem);
    
    boolean isRunning = true;
    String input = "";
    
    while(isRunning) {
      // Prompt user
      if(fileSystem.getCurrentDirectory().getDirectoryName().equals("/"))
        System.out.print(fileSystem.getCurrentDirectory().getAbsolutePath() + ": >> ");
      else
        System.out.print(fileSystem.getCurrentDirectory().getAbsolutePath() + " >> ");
      
      // Gather user input
      input = scanner.nextLine();
      
      // Process user input
      interpreter.interpret(input);
    }
    
    scanner.close();
  }
}
