package utils;

import frame.BasketballPostDetailFrame;
import frame.FutsalPostDetailFrame;
import frame.WriteFrame;
import repositories.BasketballWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasketballPageGenerator extends JPanel {
  private JFrame frame;
  private BasketballWritingRepository basketballWritingRepository;

  public BasketballPageGenerator() {
    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  public void writingList() {
    basketballWritingRepository = new BasketballWritingRepository();

    JLabel test = new JLabel("6/26 18:00 상암 농구장 팀원 모집"); // 글 제목 불러오기 필요
    this.add(test);
    test.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        JFrame basketballPostdetailPage = new BasketballPostDetailFrame();
      }
    });

  }

  public void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame writeFrame = new WriteFrame();
      setVisible(false);
    });

    this.add(writeButton);
  }
}
