package utils;

import frame.BasketballPostDetailFrame;
import frame.BasketballWriteFrame;
import frame.FutsalPostDetailFrame;
import frame.FutsalWriteFrame;
import models.Writing;
import repositories.BasketballWritingRepository;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasketballPageGenerator extends JPanel {
  private final JButton writeButton;
  private final JPanel listPanel;
  private final JButton listCheck;
  private Writing writing;
  private BasketballWritingRepository basketballWritingRepository;

  private JLabel postTitle;

  public BasketballPageGenerator
      (BasketballWritingRepository basketballWritingRepository) {
//    this.writing = writing;
    this.basketballWritingRepository = basketballWritingRepository;

    writeButton = new JButton("글 쓰기");
    writingPost(basketballWritingRepository, writeButton);

    listCheck = new JButton("목록 보기");
    listPanel = new JPanel();

    listCheck(basketballWritingRepository, listPanel);
    this.add(listCheck);
    this.add(listPanel);
  }

  public void listCheck(BasketballWritingRepository basketballWritingRepository
      , JPanel listPanel) {
    listCheck.addActionListener(event -> {
      listPanel.removeAll();

      for (String post : basketballWritingRepository.getBasketballPostTitle()) {
        postTitle = new JLabel(post);

        postTitle.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            JFrame basketballPostDetailFrame =
                new BasketballPostDetailFrame(basketballWritingRepository);
          }
        });

        listPanel.add(postTitle);
      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
  }
  public void writingPost(BasketballWritingRepository basketballWritingRepository, JButton writeButton) {
    writeButton.addActionListener(event -> {
      JFrame basketballWriteFrame =
          new BasketballWriteFrame(basketballWritingRepository);
    });
    this.add(writeButton);
  }
}
