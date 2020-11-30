package filesystem;

import java.util.HashMap;

public class Directory {

  private HashMap<String, Directory> subdirectories;
  private HashMap<String, File> files;
  private String directoryName;
  private Directory parentDirectory;


  public Directory(String name, Directory parentDirectory) {
    this.subdirectories = new HashMap<String, Directory>();
    this.files = new HashMap<String, File>();
    this.directoryName = name;
    this.parentDirectory = parentDirectory;
  }


  public String getDirectoryName() {
    return this.directoryName;
  }


  public Directory getParentDirectory() {
    return this.parentDirectory;
  }


  public HashMap<String, Directory> getSubdirectories() {
    return this.subdirectories;
  }


  public HashMap<String, File> getFiles() {
    return this.files;
  }


  public Directory getDirectory(String dirName) {
    return this.subdirectories.get(dirName);
  }


  public File getFile(String fileName) {
    return this.files.get(fileName);
  }


  public void addSubdirectory(Directory directory) {
    if (!this.subdirectories.containsKey(directory.getDirectoryName())) {
      this.subdirectories.put(directory.getDirectoryName(), directory);
    }
  }


  public void addFile(File file) {
    if (!this.files.containsKey(file.getFileName())) {
      this.files.put(file.getFileName(), file);
    }
  }


  public String getAbsolutePath() {
    return this.parentDirectory == null ? this.directoryName
        : this.parentDirectory.getAbsolutePath() + this.directoryName + "/";
  }
  
  
  public void emptySubdirectories() {
    this.subdirectories.clear();
  }
  
  
  public void removeSubdirectory(Directory directory) {
    this.subdirectories.remove(directory.getDirectoryName());
  }
}
