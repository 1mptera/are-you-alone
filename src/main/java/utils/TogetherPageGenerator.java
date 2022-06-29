package utils;

import frame.TogetherPostDetailFrame;
import frame.TogetherWriteFrame;
import frame.WriteFrame;
import models.Writing;
import repositories.TogetherWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TogetherPageGenerator extends JPanel {
  private Writing writing;
  private TogetherWritingRepository togetherWritingRepository;

  private JLabel postTitle;

  public TogetherPageGenerator(TogetherWritingRepository togetherWritingRepository) {
    this.writing = writing;
    this.togetherWritingRepository = togetherWritingRepository;

    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  private void writingList() {
    for(String post : togetherWritingRepository.getTogetherPostTitle()) {
      postTitle = new JLabel(post);
      this.add(postTitle);

      postTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JFrame togetherPostDetailFrame = new TogetherPostDetailFrame(togetherWritingRepository);
        }
      });
    }
  }

  private void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame togetherWriteFrame = new TogetherWriteFrame(togetherWritingRepository);
      setVisible(false);
    });

    this.add(writeButton);
  }
}
