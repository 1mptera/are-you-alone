package utils;

import frame.TogetherPostDetailFrame;
import frame.TogetherWriteFrame;
import repositories.TogetherWritingRepository;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TogetherPageGenerator extends JPanel {
  private final JButton writeButton;
  private final JButton listCheck;
  private final JPanel listPanel;
  private final JButton refreshButton;
  private TogetherWritingRepository togetherWritingRepository;

  private JLabel postTitle;

  public TogetherPageGenerator
      (TogetherWritingRepository togetherWritingRepository) {
    this.togetherWritingRepository = togetherWritingRepository;

    writeButton = new JButton("글 쓰기");
    writingPost(togetherWritingRepository, writeButton);

    listCheck = new JButton("목록 보기");
    listPanel = new JPanel();

    listCheck(togetherWritingRepository, listPanel);

    refreshButton = new JButton("새로 고침");
    refresh(togetherWritingRepository, listPanel);

    this.add(listCheck);
    this.add(refreshButton);
    this.add(listPanel);
  }

  public void refresh(TogetherWritingRepository togetherWritingRepository,
                      JPanel listPanel) {
    refreshButton.addActionListener(event -> {
      listPanel.removeAll();

      for(String post : togetherWritingRepository.getTogetherPostTitle()) {
        postTitle = new JLabel(post);
        listPanel.add(postTitle);

      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
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
                new TogetherPostDetailFrame(togetherWritingRepository, post);
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
