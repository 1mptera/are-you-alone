package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TogetherWritingRepository {
  private List<String> togetherTitleKey = new ArrayList<>();
  private Map<String, String> togetherTitleAndContent = new HashMap<>();
  private List<String> togetherPostTitle = new ArrayList<>();
  private String togetherPostContent;
  private String post;

  public void getTogetherWriting(String togetherTitle, String togetherContent) {
    togetherTitleKey.add(togetherTitle);

    togetherTitleAndContent.put(togetherTitle, togetherContent);

    togetherPostTitle.add(String.valueOf(togetherTitleAndContent
        .keySet()
        .toArray()[togetherTitleAndContent.size() - 1]));
  }

  public String getTogetherTitleKey(String post) {
    this.post = post;
    return post;
  }

  public void deleteTogetherWriting(String title) {
    togetherTitleAndContent.remove(title);
    togetherPostTitle.remove(title);
  }

  public String getTogetherPostContent(String title) {
    togetherPostContent = togetherTitleAndContent.get(title);
    return togetherPostContent;
  }

  public List<String> getTogetherPostTitle() {
    return togetherPostTitle;
  }
}
