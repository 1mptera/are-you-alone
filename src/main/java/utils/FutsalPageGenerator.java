package utils;

import frame.FutsalPostDetailFrame;
import frame.FutsalWriteFrame;
import models.Writing;
import repositories.FutsalWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FutsalPageGenerator extends JPanel {
  private final JButton writeButton;
  private final JButton listCheck;
  private final JPanel listPanel;
  private Writing writing;
  private FutsalWritingRepository futsalWritingRepository;

  private JLabel postTitle;

  public FutsalPageGenerator(FutsalWritingRepository futsalWritingRepository) {
//    this.writing = writing;
    this.futsalWritingRepository = futsalWritingRepository;

    writeButton = new JButton("글 쓰기");
    writingPost(futsalWritingRepository, writeButton);

    listCheck = new JButton("목록 보기");
    listPanel = new JPanel();

    listCheck(futsalWritingRepository, listPanel);
    this.add(listCheck);
    this.add(listPanel);
  }

  public void listCheck(FutsalWritingRepository futsalWritingRepository
      , JPanel listPanel) {
    listCheck.addActionListener(event -> {
      listPanel.removeAll();

      for (String post : futsalWritingRepository.getFutsalPostTitle()) {
        postTitle = new JLabel(post);

        postTitle.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame futsalPostDetailFrame =
                new FutsalPostDetailFrame(futsalWritingRepository);
          }
        });

        listPanel.add(postTitle);
      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
  }


  public void writingPost(FutsalWritingRepository futsalWritingRepository, JButton writeButton) {
    writeButton.addActionListener(event -> {
      JFrame futsalWriteFrame =
          new FutsalWriteFrame(futsalWritingRepository);
    });
    this.add(writeButton);
  }
}
