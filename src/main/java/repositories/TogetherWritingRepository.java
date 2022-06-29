package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TogetherWritingRepository {
  private String togetherTitle;
  private Map<String, String> togetherTitleAndContent = new HashMap<>();
  private List<String> togetherPostTitle = new ArrayList<>();
  private final List<String> togetherPostContent = new ArrayList<>();

  public void getTogetherWriting(String togetherTitle, String togetherContent) {
    this.togetherTitle = togetherTitle;
    togetherTitleAndContent.put(togetherTitle, togetherContent);

    togetherPostTitle.add(String.valueOf(togetherTitleAndContent
        .keySet()
        .toArray()[togetherTitleAndContent.size() - 1]));
  }

  public String getTogetherTitleKey() {

    return togetherTitle;
  }

  public List<String> getTogetherPostContent(String title) {
    togetherPostContent.add(togetherTitleAndContent.get(title));

    return togetherPostContent;
  }

  public void deleteTogetherWriting(String title) {
    togetherTitleAndContent.remove(title);
  }

  public List<String> getTogetherPostTitle() {
//    if (!togetherTitleAndContent.isEmpty()) {
//      for(int i = 0; i < titleAndContent.size(); i += 1) {
//        postTitle.add(String.valueOf(titleAndContent.keySet().toArray()[i]));
//이 방법은 모든 글을 불러올 때 -> 기존에 있던 글들을 지우고 다시 출력하면 될 듯 싶은데
//      }
//      togetherPostTitle.add(String.valueOf(togetherTitleAndContent
//          .keySet()
//          .toArray()[togetherTitleAndContent.size() - 1]));
//이 방법은 마지막 글만 불러올 때
//    }
    return togetherPostTitle;
  }
}
