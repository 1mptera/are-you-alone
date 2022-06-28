package frame;

import javax.swing.*;
import java.awt.*;

public class BasketballPostDetailFrame extends JFrame {
  private final JFrame frame;
  private JPanel panel;

  public BasketballPostDetailFrame() {
    frame = new JFrame("상세 페이지");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 800);

    loadContent();

    frame.setVisible(true);
  }

  public void loadContent() {
    panel = new JPanel();
    frame.add(panel);
    panel.setLayout(null);

    panel.add(createContent());
    panel.add(createDeleteButton());
    panel.add(createModifyButton());
  }

  public JButton createModifyButton() {
    JButton modifyButton = new JButton("수정하기");
    modifyButton.setBounds(530,700,100,40);
    modifyButton.addActionListener(event -> {
      // 글 수정
    });
    return modifyButton;
  }

  public JButton createDeleteButton() {
    JButton deleteButton = new JButton("삭제하기");
    deleteButton.setBounds(650,700,100,40);
    deleteButton.addActionListener(event -> {
      // 글 삭제
    });
    return deleteButton;
  }

  public JLabel createContent() {
    JLabel label = new JLabel("6/26 18:00 상암 농구장에서 농구 5:5 같이 " +
        "하실분 구합니다. 매너좋은신 분 환영!! 010-xxxx-xxxx 연락부탁드립니다. ");
    label.setBounds(10,10,700,600);

    return label;
  }
}
