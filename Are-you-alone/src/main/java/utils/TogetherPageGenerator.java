package utils;

import frame.FutsalPostDetailFrame;
import frame.TogetherPostDetailFrame;
import frame.WriteFrame;
import repositories.TogetherWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TogetherPageGenerator extends JPanel {
  private TogetherWritingRepository togetherWritingRepository;

  public TogetherPageGenerator() {
    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  private void writingList() {
    togetherWritingRepository = new TogetherWritingRepository();

    JLabel test = new JLabel("6/28 17:00 강북구 근처에서 테니스 같이 하실 분?"); // 글 제목 불러오기 필요
    this.add(test);
    test.addMouseListener(new MouseAdapter() {

      public void mouseClicked(MouseEvent e) {
        JFrame togetherPostdetailPage = new TogetherPostDetailFrame();
      }
    });
  }

  private void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame writeFrame = new WriteFrame();
      setVisible(false);
    });

    this.add(writeButton);
  }
}
