package utils;

import models.Writing;

import javax.swing.*;

public class MainPageGenerator extends JPanel {
  public MainPageGenerator(Writing writing) {
    for(String post : writing.getPostTitle()) {
      JLabel postTitle = new JLabel(post);
      this.add(postTitle);
    }
  }
}
