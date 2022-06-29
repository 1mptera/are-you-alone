package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketballWritingRepository {
  private String basketballTitle;
  private Map<String, String> basketballTitleAndContent = new HashMap<>();
  private List<String> basketballPostTitle = new ArrayList<>();
  private final List<String> basketballPostContent = new ArrayList<>();

  public void getBasketballWriting(String basketballTitle, String basketballContent) {
    this.basketballTitle = basketballTitle;
    basketballTitleAndContent.put(basketballTitle, basketballContent);
  }

  public String getBasketballTitleKey() {
    return basketballTitle;
  }


  public List<String> getBasketballPostContent(String title) {
    basketballPostContent.add(basketballTitleAndContent.get(title));

    return basketballPostContent;
  }

  public List<String> getBasketballPostTitle() {
    if (!basketballTitleAndContent.isEmpty()) {
//      for(int i = 0; i < titleAndContent.size(); i += 1) {
//        postTitle.add(String.valueOf(titleAndContent.keySet().toArray()[i]));
//이 방법은 모든 글을 불러올 때 -> 기존에 있던 글들을 지우고 다시 출력하면 될 듯 싶은데
//      }
      basketballPostTitle.add(String.valueOf(basketballTitleAndContent
          .keySet()
          .toArray()[basketballTitleAndContent.size() - 1]));
//이 방법은 마지막 글만 불러올 때
    }
    return basketballPostTitle;
  }
}
