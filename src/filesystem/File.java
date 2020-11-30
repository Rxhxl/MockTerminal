package filesystem;

public class File {
  
  private String fileName;
  private String fileContents;
  
  
  public File(String fileName) {
    this.fileName = fileName;
    this.fileContents = "";
  }
  
  
  /**
   * Retrieves the name of the file.
   * 
   * @return String that is the name of the file
   */
  public String getFileName() {
    return this.fileName;
  }
  
  
  /**
   * Assigns fileName to be the name of the file.
   * 
   * @param fileName   the name of the file
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
  
  
  /**
   * Retrieves the contents of the file.
   * 
   * @return String that contains contents of the file
   */
  public String getFileContents() {
    return this.fileContents;
  }
  
  
  /**
   * Assigns the fileContents to be the new contents of the file.
   * @param fileContents    the new contents of the file
   */
  public void setFileContents(String fileContents) {
    this.fileContents = fileContents;
  }
}
