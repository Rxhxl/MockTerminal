package commands;

import java.util.List;

public interface Command {
  
  public void run(List<String> tokens) throws Exception;
  
}
