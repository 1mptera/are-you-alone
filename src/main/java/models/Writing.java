package models;

import java.util.ArrayList;
import java.util.List;

public class Writing {

  private List<String> postTitle = new ArrayList<>();
  private List<String> postContent = new ArrayList<>();

  public void getWriting(String title) {

    postTitle.add(title);
  }

  public List<String> getPostTitle() {
    return postTitle;
  }

  public void getContent(String content) {

    postContent.add(content);
  }

  public List<String> getPostContent() {
    return postContent;
  }
}
