package commands;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class loads the previous session of a saved JShell by the user
 * and returns the state of the current session to what it was before.
 */
public class LoadJShell implements Command {
  
  @Override
  public void run(List<String> tokens) {
    load(tokens.get(1));
  }
  
  
  /**
   * This method returns the deserialized objects from the saved file
   * in order to return the state of the JShell to its previous state.
   * 
   * @param fileName the fileName where the previous session was stored
   * @return         the List of objects that we saved from the session
   */
  @SuppressWarnings("unchecked")
  public ArrayList<Object> load(String fileName) {
    try {
      FileInputStream fileIn = new FileInputStream(fileName);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      
      // Unpack the data the user saved
      ArrayList<Object> list = (ArrayList<Object>)in.readObject();
      in.close();
      fileIn.close();
      return list;
    } catch(Exception e) {
      System.out.println("Unable to load JShell successfully.");
      return null;
    }
  }
}
