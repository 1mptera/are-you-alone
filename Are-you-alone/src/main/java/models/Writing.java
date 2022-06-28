package models;

import java.util.ArrayList;
import java.util.List;

public class Writing {

  private List<String> posts = new ArrayList<>();

  public void getWriting(String title) {
    posts.add(title);
  }

  public List<String> getPosts() {

    return posts;
  }
}
