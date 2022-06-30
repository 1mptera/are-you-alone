package utils;

import frame.BasketballPostDetailFrame;
import frame.BasketballWriteFrame;
import repositories.BasketballWritingRepository;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasketballPageGenerator extends JPanel {
  private final JButton writeButton;
  private final JPanel listPanel;
  private final JButton listCheck;
  private final JButton refreshButton;
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

    refreshButton = new JButton("새로 고침");
    refresh(basketballWritingRepository, listPanel);

    this.add(listCheck);
    this.add(refreshButton);
    this.add(listPanel);
  }

  public void refresh(BasketballWritingRepository basketballWritingRepository,
                       JPanel listPanel) {
    refreshButton.addActionListener(event -> {
      listPanel.removeAll();

      for(String post : basketballWritingRepository.getBasketballPostTitle()) {
        postTitle = new JLabel(post);
        listPanel.add(postTitle);

      }

      listPanel.setVisible(false);
      listPanel.setVisible(true);
    });
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
                new BasketballPostDetailFrame(basketballWritingRepository, post);
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
