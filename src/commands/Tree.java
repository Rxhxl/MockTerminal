package commands;

import filesystem.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class Tree implements Command {
  
  private FileSystem fileSystem;
          
  
  public Tree(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }
  
  
  @Override
  public void run(List<String> tokens) {
    tree();
  }
  
  public void tree() {
    System.out.println("\\");
    treeRecursive(this.fileSystem.getRoot(), " ");
  }
  
  
  public void treeRecursive(Directory currentDirectory, String shift) {
    Stack<Directory> stack = new Stack<Directory>();
    HashMap<String, Directory> subdirectories;
    HashMap<String, File> files;
    
    subdirectories = currentDirectory.getSubdirectories();
    
    subdirectories.forEach((str, dir) -> {
      stack.add(dir);
    });
    
    while(!stack.isEmpty()) {
      Directory temp = stack.pop();
      System.out.println(shift + temp.getDirectoryName());
      files = temp.getFiles();
      files.forEach((str, file) -> {
        System.out.println(shift + "  " + file.getFileName());
      });
      treeRecursive(temp, shift + "  ");
    }
  }
}
