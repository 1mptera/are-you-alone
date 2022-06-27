package utils;

import javax.swing.*;
import java.awt.*;

public class WriteFrame extends JFrame {
  private final JFrame frame;

  public WriteFrame() {
    frame = new JFrame("Are you alone?");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 800);

    write();


    frame.setVisible(true);
  }

  private void write() {
    JPanel panel = new JPanel();
    frame.add(panel);
    panel.setLayout(null);

    JTextField title = new JTextField(20);
    title.setBounds(50,10, 700, 40);
    panel.add(title);

    JTextArea content = new JTextArea();
    content.setBounds(50,60,700, 600);
    panel.add(content);

    JButton transmitButton = new JButton("글 작성하기");
    transmitButton.addActionListener(event -> {

    });
    transmitButton.setBounds(650,700,100,40);
    panel.add(transmitButton);

  }
}
