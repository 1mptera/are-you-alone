package utils;

import repositories.FutsalWritingRepository;

import javax.swing.*;
import java.awt.*;

public class FutsalPageGenerator extends JPanel {

  public FutsalPageGenerator() {
    setLayout(new GridLayout(3,1));

    writingList();
    writeButton();
  }

  public void writingList() {
    FutsalWritingRepository futsalWritingRepository =
        new FutsalWritingRepository();

    String writing = futsalWritingRepository.getWriting();
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
