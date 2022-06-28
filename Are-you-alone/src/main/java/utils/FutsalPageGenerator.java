package utils;

import frame.FutsalPostDetailFrame;
import frame.WriteFrame;
import repositories.FutsalWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FutsalPageGenerator extends JPanel {
  private FutsalWritingRepository futsalWritingRepository;

  public FutsalPageGenerator() {
    setLayout(new GridLayout(3, 1));

    writingList();
    writeButton();
  }

  public void writingList() {
    futsalWritingRepository = new FutsalWritingRepository();

    for (String titleList : futsalWritingRepository.getTitle()) {
      this.add(new JLabel(titleList));
    }

    JLabel test = new JLabel("6/26 17:00 메가테라 스타디움 팀원 모집"); // 글 제목 불러오기 필요
    this.add(test);
    test.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        JFrame futsalPostdetailPage = new FutsalPostDetailFrame();
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

//    JTextField textField = new JTextField(10);
//    this.add(textField);
//    JButton transmitButton = new JButton("글 작성하기");
//    transmitButton.addActionListener(event -> {
//      String title = textField.getText();
//      JLabel label = new JLabel(title);
//      this.add(label);
//    });
//    this.add(transmitButton);

//    String writing = futsalWritingRepository.getWriting();
//    JLabel label = new JLabel(writing);
//    this.add(label);
