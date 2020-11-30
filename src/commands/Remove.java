package commands;

import filesystem.Directory;
import filesystem.FileSystem;
import java.util.List;

public class Remove implements Command {

  private FileSystem fileSystem;

  public Remove(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  
  @Override
  public void run(List<String> tokens) {
    remove(tokens.get(1));
  }
  
  private Directory setStartingDirectory(String path) {
    return path.startsWith("/") ? fileSystem.getRoot() : 
      fileSystem.getCurrentDirectory();
  }

  
  private void remove(String path) {
    Directory currentDirectory = setStartingDirectory(path);

    if (path.startsWith("/"))
      path = path.substring(1);

    String[] pathList = path.split("/");

    for (int i = 0; i < pathList.length; i++) {
      if (pathList[i].equals(".")) {
        continue;
      } else if (pathList[i].equals("..")) {
        if (currentDirectory.getParentDirectory() != null) {
          // If current directory isn't the root
          currentDirectory = currentDirectory.getParentDirectory();
        } else {
          continue;
        }
      } else {
        if (currentDirectory.getDirectory(pathList[i]) == null) {
          currentDirectory.addSubdirectory(new Directory(pathList[i], currentDirectory));
          currentDirectory = currentDirectory.getDirectory(pathList[i]);
        } else {
          currentDirectory = currentDirectory.getDirectory(pathList[i]);
        }
      }
    }

    currentDirectory.emptySubdirectories();
    currentDirectory.getParentDirectory().removeSubdirectory(currentDirectory);
  }
}
