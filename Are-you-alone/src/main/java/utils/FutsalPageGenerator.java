package utils;

import repositories.FutsalWritingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FutsalPageGenerator extends JPanel {
  private FutsalWritingRepository futsalWritingRepository;
  private JFrame frame;


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
        frame = new JFrame("상세 페이지");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 800);

        loadContent();

        frame.setVisible(true);
      }

      private void loadContent() {
        JLabel content = new JLabel("6/26 17:00 메가테라 스타디움에서 풋살 5:5 같이 " +
            "즐기실 분 010-xxxx-xxxx 연락부탁드립니다. ");
        frame.add(content);
      }
    });
  }

  private void writeButton() {
    JButton writeButton = new JButton("글 쓰기");
    writeButton.addActionListener(event -> {
      JFrame writeFrame = new WriteFrame();
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
