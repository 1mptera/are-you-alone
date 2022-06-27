package utils;

import repositories.TogetherWritingRepository;

import javax.swing.*;
import java.awt.*;

public class TogetherPageGenerator extends JPanel {
  public TogetherPageGenerator() {
    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  private void writingList() {
    TogetherWritingRepository togetherWritingRepository =
        new TogetherWritingRepository();

    String writing = togetherWritingRepository.getWriting();
    JLabel label = new JLabel(writing);
    this.add(label);
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
