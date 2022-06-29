package frame;

import models.Writing;
import repositories.BasketballWritingRepository;

import javax.swing.*;

public class BasketballWriteFrame extends JFrame {
  private final JFrame frame;
  private Writing writing;
  private BasketballWritingRepository basketballWritingRepository;

  public BasketballWriteFrame(BasketballWritingRepository basketballWritingRepository) {
    this.writing = writing;
    this.basketballWritingRepository = basketballWritingRepository;

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

    JTextField titleBox = new JTextField(20);
    titleBox.setBounds(50,10, 700, 40);
    panel.add(titleBox);

    JTextArea contentBox = new JTextArea();
    contentBox.setBounds(50,60,700, 600);
    panel.add(contentBox);

    JButton transmitButton = new JButton("글 작성하기");

    transmitButton.addActionListener(event -> {
      String futsalTitle = titleBox.getText();
      String futsalContent = contentBox.getText();
      basketballWritingRepository.getBasketballWriting(futsalTitle, futsalContent);

      frame.setVisible(false);
    });

    transmitButton.setBounds(650,700,100,40);
    panel.add(transmitButton);

  }
}
