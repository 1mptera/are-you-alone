package utils;

import frame.BasketballPostDetailFrame;
import frame.BasketballWriteFrame;
import frame.WriteFrame;
import models.Writing;
import repositories.BasketballWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasketballPageGenerator extends JPanel {
  private Writing writing;
  private BasketballWritingRepository basketballWritingRepository;

  private JLabel postTitle;

  public BasketballPageGenerator(BasketballWritingRepository basketballWritingRepository) {
//    this.writing = writing;
    this.basketballWritingRepository = basketballWritingRepository;

    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  public void writingList() {
    for(String post : basketballWritingRepository.getBasketballPostTitle()) {
      postTitle = new JLabel(post);

      postTitle.removeAll();
      this.add(postTitle);

      postTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          JFrame basketballPostDetailPage =
              new BasketballPostDetailFrame(basketballWritingRepository);
        }
      });
    }
  }

  public void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame basketballWriteFrame =
          new BasketballWriteFrame(basketballWritingRepository);
      setVisible(false);
    });

    this.add(writeButton);
  }
}
