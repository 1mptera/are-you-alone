package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FutsalWritingRepository {
  private String futsalTitle;
  private Map<String, String> futsalTitleAndContent = new HashMap<>();
  private List<String> futsalPostTitle = new ArrayList<>();
  private final List<String> futsalPostContent = new ArrayList<>();

  public void getFutsalWriting(String futsalTitle, String futsalContent) {
    this.futsalTitle = futsalTitle;
    futsalTitleAndContent.put(futsalTitle, futsalContent);
  }

  public String getFutsalTitleKey() {
    return futsalTitle;
  }


  public List<String> getFutsalPostContent(String title) {
    futsalPostContent.add(futsalTitleAndContent.get(title));

    return futsalPostContent;
  }

  public List<String> getFusalPostTitle() {
    if (!futsalTitleAndContent.isEmpty()) {
//      for(int i = 0; i < titleAndContent.size(); i += 1) {
//        postTitle.add(String.valueOf(titleAndContent.keySet().toArray()[i]));
//이 방법은 모든 글을 불러올 때 -> 기존에 있던 글들을 지우고 다시 출력하면 될 듯 싶은데
//      }
      futsalPostTitle.add(String.valueOf(futsalTitleAndContent
          .keySet()
          .toArray()[futsalTitleAndContent.size() - 1]));
//이 방법은 마지막 글만 불러올 때
    }
    return futsalPostTitle;
  }
}
