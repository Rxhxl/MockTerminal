package filesystem;

import java.io.Serializable;
import java.util.Stack;

public class FileSystem implements Serializable {

  private static final long serialVersionUID = 1L;
  private Directory rootDirectory;
  private Directory currentDirectory;
  private Stack<String> directoryStack;
  
  public FileSystem() {
    this.rootDirectory = new Directory("/", null);
    this.currentDirectory = this.rootDirectory;
    this.directoryStack = new Stack<String>();
  }
  
  
  public Directory getCurrentDirectory() {
    return this.currentDirectory;
  }
  
  
  public Directory getRoot() {
    return this.rootDirectory;
  }
  
  
  public void setCurrentDirectory(Directory currentDirectory) {
    this.currentDirectory = currentDirectory;
  }
  
  
  public void addToDirectoryStack(String newDirectoryPath) {
    this.directoryStack.add(newDirectoryPath);
  }
  
  
  public Stack<String> getDirectoryStack() {
    return this.directoryStack;
  }
  
  
  public String popFromDirectoryStack() {
    return this.directoryStack.pop();
  }
}
