package utils;

import frame.FutsalPostDetailFrame;
import frame.WriteFrame;
import models.Writing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FutsalPageGenerator extends JPanel {
  private Writing writing;
  private JLabel postTitle;

  public FutsalPageGenerator(Writing writing) {
    this.writing = writing;

    setLayout(new GridLayout(3, 1));

    writingList();
    writeButton();
  }

  public void writingList() {
    for(String post : writing.getPostTitle()) {
      postTitle = new JLabel(post);
      this.add(postTitle);

      postTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JFrame futsalPostdetailPage = new FutsalPostDetailFrame(writing);
        }
      });
    }
  }

  public void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame writeFrame = new WriteFrame(writing);
    });

    this.add(writeButton);
  }
}
