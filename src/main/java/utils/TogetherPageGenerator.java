package utils;

import frame.TogetherPostDetailFrame;
import frame.WriteFrame;
import models.Writing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TogetherPageGenerator extends JPanel {
  private Writing writing;
  private JLabel postTitle;

  public TogetherPageGenerator(Writing writing) {
    this.writing = writing;

    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  private void writingList() {
    for(String post : writing.getPostTitle()) {
      postTitle = new JLabel(post);
      this.add(postTitle);

      postTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JFrame togetherPostDetailFrame = new TogetherPostDetailFrame(writing);
        }
      });
    }
  }

  private void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame writeFrame = new WriteFrame(writing);
      setVisible(false);
    });

    this.add(writeButton);
  }
}
