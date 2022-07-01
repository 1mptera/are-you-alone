package utils;

import frame.FutsalPostDetailFrame;
import frame.FutsalWriteFrame;
import repositories.FutsalWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FutsalPageGenerator extends JPanel {
  private final JButton writeButton;
  private final JButton listCheck;
  private final JButton refreshButton;
  private final JPanel listPanel;
  private FutsalWritingRepository futsalWritingRepository;

  private JLabel postTitle;

  public FutsalPageGenerator(FutsalWritingRepository futsalWritingRepository) {
    this.futsalWritingRepository = futsalWritingRepository;
    this.setLayout(new BorderLayout());

    writeButton = new JButton("글 쓰기");
    writingPost(futsalWritingRepository, writeButton);

    listCheck = new JButton("목록 보기");
    listPanel = new JPanel();

    listCheck(futsalWritingRepository, listPanel);

    refreshButton = new JButton("새로 고침");
    refresh(futsalWritingRepository, listPanel);

    this.add((writeButton), BorderLayout.NORTH);
    this.add((listCheck), BorderLayout.WEST);
    this.add((refreshButton), BorderLayout.EAST);
    this.add((listPanel), BorderLayout.SOUTH);
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
                new FutsalPostDetailFrame(futsalWritingRepository, post);
          }
        });

        listPanel.add(postTitle);
      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
  }

  public void refresh(FutsalWritingRepository futsalWritingRepository,
                      JPanel listPanel) {
    refreshButton.addActionListener(event -> {
      listPanel.removeAll();

      for(String post : futsalWritingRepository.getFutsalPostTitle()) {
        postTitle = new JLabel(post);

        postTitle.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame futsalPostDetailFrame =
                new FutsalPostDetailFrame(futsalWritingRepository, post);
          }
        });

        listPanel.add(postTitle);
      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
  }

  public void writingPost(FutsalWritingRepository futsalWritingRepository,
                          JButton writeButton) {
    writeButton.addActionListener(event -> {
      JFrame futsalWriteFrame =
          new FutsalWriteFrame(futsalWritingRepository);
    });
  }
}
