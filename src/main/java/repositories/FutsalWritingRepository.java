package repositories;

import java.util.*;

public class FutsalWritingRepository {
  private List<String> futsalTitleKey = new ArrayList<>();
  private Map<String, String> futsalTitleAndContent = new LinkedHashMap<>();
  private List<String> futsalPostTitle = new ArrayList<>();
  private String futsalPostContent;
  private String post;

  public void getFutsalWriting(String futsalTitle, String futsalContent) {
    futsalTitleKey.add(futsalTitle);

    futsalTitleAndContent.put(futsalTitle, futsalContent);

    futsalPostTitle.add(String.valueOf(futsalTitleAndContent
        .keySet()
        .toArray()[futsalTitleAndContent.size() - 1]));
  }

  public String getFutsalTitleKey(String post) {
    this.post = post;
    return post;
  }

  public void deleteFutsalWriting(String title) {
    futsalTitleAndContent.remove(title);
    futsalPostTitle.remove(title);
  }

  public String getFutsalPostContent(String title) {
    futsalPostContent = futsalTitleAndContent.get(title);
    return futsalPostContent;
  }

  public List<String> getFutsalPostTitle() {
    return futsalPostTitle;
  }
}
