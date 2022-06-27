package utils;

import repositories.BasketballWritingRepository;

import javax.swing.*;
import java.awt.*;

public class BasketballPageGenerator extends JPanel {
  public BasketballPageGenerator() {
    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  public void writingList() {
    BasketballWritingRepository basketballWritingRepository =
        new BasketballWritingRepository();

    String writing = basketballWritingRepository.getWriting();
    JLabel label = new JLabel(writing);
    this.add(label);
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
