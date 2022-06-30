package repositories;

import java.util.*;

public class BasketballWritingRepository {
  private List<String> basketballTitleKey = new ArrayList<>();
  private Map<String, String> basketballTitleAndContent = new HashMap<>();
  private List<String> basketballPostTitle = new ArrayList<>();
  private String basketballPostContent;
  private String post;

  public void getBasketballWriting
      (String basketballTitle, String basketballContent) {
    basketballTitleKey.add(basketballTitle);

    basketballTitleAndContent.put(basketballTitle, basketballContent);

    basketballPostTitle.add(String.valueOf(basketballTitleAndContent
        .keySet()
        .toArray()[basketballTitleAndContent.size() - 1]));
  }

  public void deleteBasketballWriting(String title) {
    basketballTitleAndContent.remove(title);
    basketballPostTitle.remove(title);
  }

  public String getBasketballTitleKey(String post) {
    this.post = post;
    return post;
  }


  public String getBasketballPostContent(String title) {
    basketballPostContent = basketballTitleAndContent.get(title);

    return basketballPostContent;
  }

  public List<String> getBasketballPostTitle() {
    return basketballPostTitle;
  }
}
