package utils;

import frame.FutsalPostDetailFrame;
import frame.FutsalWriteFrame;
import frame.TogetherPostDetailFrame;
import frame.TogetherWriteFrame;
import models.Writing;
import repositories.FutsalWritingRepository;
import repositories.TogetherWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TogetherPageGenerator extends JPanel {
  private final JButton writeButton;
  private final JButton listCheck;
  private final JPanel listPanel;
  private Writing writing;
  private TogetherWritingRepository togetherWritingRepository;

  private JLabel postTitle;

  public TogetherPageGenerator(TogetherWritingRepository togetherWritingRepository) {
    this.writing = writing;
    this.togetherWritingRepository = togetherWritingRepository;

    writeButton = new JButton("글 쓰기");
    writingPost(togetherWritingRepository, writeButton);

    listCheck = new JButton("목록 보기");
    listPanel = new JPanel();

    listCheck(togetherWritingRepository, listPanel);
    this.add(listCheck);
    this.add(listPanel);

  }
  public void listCheck(TogetherWritingRepository togetherWritingRepository
      , JPanel listPanel) {
    listCheck.addActionListener(event -> {
      listPanel.removeAll();

      for (String post : togetherWritingRepository.getTogetherPostTitle()) {
        postTitle = new JLabel(post);

        postTitle.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame togetherPostDetailFrame =
                new TogetherPostDetailFrame(togetherWritingRepository);
          }
        });

        listPanel.add(postTitle);
      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
  }

  public void writingPost(TogetherWritingRepository togetherWritingRepository, JButton writeButton) {
    writeButton.addActionListener(event -> {
      JFrame togetherWriteFrame =
          new TogetherWriteFrame(togetherWritingRepository);
    });
    this.add(writeButton);
  }

}
