package repositories;

import java.util.*;

public class FutsalWritingRepository {
  private String futsalTitle;
  private Map<String, String> futsalTitleAndContent = new LinkedHashMap<>();
  private List<String> futsalPostTitle = new ArrayList<>();
  private String futsalPostContent;

  public void getFutsalWriting(String futsalTitle, String futsalContent) {
    this.futsalTitle = futsalTitle;
    futsalTitleAndContent.put(futsalTitle, futsalContent);

    futsalPostTitle.add(String.valueOf(futsalTitleAndContent
        .keySet()
        .toArray()[futsalTitleAndContent.size() - 1]));
  }

  public String getFutsalTitleKey() {
    return futsalTitle;
  }

  public void deleteFutsalWriting(String title) {
    futsalTitleAndContent.remove(title);
  }

  public String getFutsalPostContent(String title) {
    futsalPostContent = futsalTitleAndContent.get(title);
//        add(futsalTitleAndContent.getOrDefault(title, "글 없음"));
    return futsalPostContent;
  }

  public List<String> getFutsalPostTitle() {
//    if (!futsalTitleAndContent.isEmpty()) {
//      for (int i = 0; i < futsalTitleAndContent.size(); i += 1) {
//      }
//이 방법은 모든 글을 불러올 때 -> 기존에 있던 글들을 지우고 다시 출력하면 될 듯 싶은데

//      futsalPostTitle = String.valueOf(futsalTitleAndContent
//          .keySet()
//          .toArray()[futsalTitleAndContent.size() - 1]);
//          add(String.valueOf(futsalTitleAndContent
//          .keySet()
//          .toArray()[futsalTitleAndContent.size() - 1]));
//이 방법은 마지막 글만 불러올 때
//    }
    return futsalPostTitle;
  }
}
