package repositories;

import java.util.ArrayList;
import java.util.List;

public class FutsalWritingRepository {

  private List<String> titleLists = new ArrayList<>();

  public void getWriting(String title) {
     titleLists.add(title);
  }

  public List<String> getTitle() {
    return titleLists;
  }
}
