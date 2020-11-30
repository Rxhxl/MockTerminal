package commands;

import filesystem.FileSystem;
import filesystem.File;
import java.util.HashMap;
import filesystem.Directory;

public class List implements Command {
  
  private FileSystem fileSystem;

  @Override
  public void run(java.util.List<String> tokens) {
    if (tokens.size() > 1) {
      if (tokens.get(1).equals("-R") && 
          tokens.size() == 2) {
        recursiveList(".");
      }
      else if (tokens.get(1).equals("-R")) {
        for (int i = 2; i < tokens.size(); i++) {
          recursiveList(tokens.get(i));
        }
      }
      else {
        for (int i = 1; i < tokens.size(); i++) {
          list(tokens.get(i));
        }
      }
    } else {
        list(".");
      } 
  }

  
  /**
   * Constructor for List with an already existing FileSystem
   * 
   * @param fileSystem The FileSystem being used
   */
  public List(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  
  /**
   * Responsible for listing the files for a given path
   * 
   * @param path String that is the directory path that is to be printed
   */
  private void list(String path) {
    Directory currentDirectory;
    String[] pathList;

    // Decide which directory to start from
    if (path.startsWith("/")) {
      path = path.substring(1);
      // Sets start to root directory
      currentDirectory = fileSystem.getRoot();
    } else {
      // Sets start to the current directory
      currentDirectory = fileSystem.getCurrentDirectory();
    }
    
    pathList = path.split("/");

    for (int i = 0; i < pathList.length; i++) {
        if (pathList[i].equals(".")) continue;
        // Go to parent directory
        if (pathList[i].equals("..")) {
        if (currentDirectory.getParentDirectory() != null) {
          // If current directory isn't the root
          currentDirectory = currentDirectory.getParentDirectory();
        }
      } else {
        currentDirectory = currentDirectory.getDirectory(pathList[i]);
        if (currentDirectory == null) {
          System.out.println("Directory \"" + pathList[i] + "\" was not " 
        + "found.");
          return;
        }
      }
    }

    HashMap<String, Directory> subdirectories = currentDirectory.
        getSubdirectories();
    HashMap<String, File> files = currentDirectory.getFiles();

    System.out.print(currentDirectory.getDirectoryName() + ": ");
    
    subdirectories.forEach((key, value) -> System.out.print(key + ", "));

    files.forEach((key, value) -> System.out.println(key + ", "));
    System.out.print("\n");
  }
  
  
  /**
   * Responsible for listing the files for a given path recursively give -R
   * 
   * @param path String that is the directory path that is to be printed
   */
  private void recursiveList(String path) {
    Directory currentDirectory;
    String[] pathList;
    String originalPath = path; 
    
    // Decide which directory to start from
    if (path.startsWith("/")) {
      path = path.substring(1);
      // Sets start to root directory
      currentDirectory = fileSystem.getRoot();
    } else {
      // Sets start to the current directory
      currentDirectory = fileSystem.getCurrentDirectory();
    }
    
    pathList = path.split("/");

    for (int i = 0; i < pathList.length; i++) {
        if (pathList[i].equals(".")) continue;
        // Go to parent directory
        if (pathList[i].equals("..")) {
        if (currentDirectory.getParentDirectory() != null) {
          // If current directory isn't the root
          currentDirectory = currentDirectory.getParentDirectory();
        }
      } else {
        currentDirectory = currentDirectory.getDirectory(pathList[i]);
        if (currentDirectory == null) {
          System.out.println("Directory \"" + pathList[i] + "\" was not " 
        + "found.");
          return;
        }
      }
    }

    HashMap<String, Directory> subdirectories = currentDirectory.
        getSubdirectories();
    HashMap<String, File> files = currentDirectory.getFiles();
    
    System.out.print(currentDirectory.getDirectoryName() + ": ");
    
    subdirectories.forEach((key, value) -> System.out.print(key + ", "));

    files.forEach((key, value) -> System.out.print(key + ", "));
    
    System.out.print("\n");
    
    subdirectories.forEach((key, value) -> recursiveList(originalPath + "/" + key));
  }

  
  /**
   * toString function used by the Man class
   * 
   * @return Returns a string that states the functionality of the ls command
   */
  public String toString() {
    return "ls [PATH ..] - If no paths are given, print the contents "
        + "(file or directory) of the current directory, with a new line "
        + "following each of the content (file or directory). "
        + "Otherwise, for each path p, the order listed: \n" + "- If p "
        + "speci:ies a file, print p\n"
        + "- f p speci:ies a directory, print p, a colon, then the contents "
        + "of that directory, then an extra new line.\n"
        + "- If p does not exist, print a suitable message.";
  }
}
