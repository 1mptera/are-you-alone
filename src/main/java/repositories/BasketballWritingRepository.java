package repositories;

import java.util.*;

public class BasketballWritingRepository {
  private Map<String, String> basketballTitleAndContent = new HashMap<>();
  private List<String> basketballPostTitle = new ArrayList<>();
  private String basketballPostContent;
  private String post;

  public void getBasketballWriting
      (String basketballTitle, String basketballContent) {
    basketballTitleAndContent.put(basketballTitle, basketballContent);

    basketballPostTitle.add(String.valueOf(basketballTitleAndContent
        .keySet()
        .toArray()[basketballTitleAndContent.size() - 1]));
  }

  public String getBasketballTitleKey(String post) {
    this.post = post;
    return post;
  }


  public List<String> getBasketballPostTitle() {

    return basketballPostTitle;
  }

  public String getBasketballPostContent(String title) {
    basketballPostContent = basketballTitleAndContent.get(title);

    return basketballPostContent;
  }

  public void deleteBasketballWriting(String title) {
    basketballTitleAndContent.remove(title);
    basketballPostTitle.remove(title);
  }

  public void changeBasketballWriting(String post,
                                      String modifiedTitle,
                                      String modifiedContent) {
    basketballPostTitle.set(basketballPostTitle.indexOf(post),modifiedTitle);
    basketballPostTitle.remove(modifiedTitle);
    basketballTitleAndContent.replace(post, modifiedContent);
  }
}
