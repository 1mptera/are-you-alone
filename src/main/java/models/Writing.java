package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Writing {

  private String title;
  private Map<String, String> titleAndContent = new HashMap<>();
  private List<String> postTitle = new ArrayList<>();
  private List<String> postContent = new ArrayList<>();

  public void getWriting(String title, String content) {
    this.title = title;
    titleAndContent.put(title, content);
  }

  public String getTitleKey() {
    return title;
  }

//  public void deleteWriting(String title) {
//    titleAndContent.remove(title);
//  }

  public List<String> getPostTitle() {
    if (!titleAndContent.isEmpty()) {
//      for(int i = 0; i < titleAndContent.size(); i += 1) {
//        postTitle.add(String.valueOf(titleAndContent.keySet().toArray()[i]));
//이 방법은 모든 글을 불러올 때 -> 기존에 있던 글들을 지우고 다시 출력하면 될 듯 싶은데
//      }
      postTitle.add(String.valueOf(titleAndContent.keySet().toArray()[titleAndContent.size() - 1]));
//이 방법은 마지막 글만 불러올 때
    }
    return postTitle;
  }

  public List<String> getPostContent(String title) {
//    if (!titleAndContent.isEmpty()) {
//      for(int i = 0; i < titleAndContent.size(); i += 1) {
//        postContent.add(String.valueOf(titleAndContent.values().toArray()[i]));
//      }
//      postContent.add(String.valueOf(titleAndContent.values().toArray()[titleAndContent.size() - 1]));
      postContent.add(titleAndContent.get(title));
//    }
    return postContent;
  }
}
