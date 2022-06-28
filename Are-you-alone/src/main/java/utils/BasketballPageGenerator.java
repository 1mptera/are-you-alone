package utils;

import frame.BasketballPostDetailFrame;
import frame.WriteFrame;
import models.Writing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasketballPageGenerator extends JPanel {
  private Writing writing;
  private JLabel postTitle;

  public BasketballPageGenerator(Writing writing) {
    this.writing = writing;

    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  public void writingList() {
    for(String post : writing.getPosts()) {
      postTitle = new JLabel(post);
      this.add(postTitle);

      postTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JFrame basketballPostDetailPage = new BasketballPostDetailFrame();
        }
      });
    }
  }

  public void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame writeFrame = new WriteFrame(writing);
      setVisible(false);
    });

    this.add(writeButton);
  }
}
