package frame;

import models.Writing;

import javax.swing.*;
import java.awt.*;

public class BasketballPostDetailFrame extends JFrame {
  private final JFrame frame;
  private JPanel panel;
  private JLabel postContent;

  private Writing writing;

  public BasketballPostDetailFrame(Writing writing) {
    this.writing = writing;
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

  public JLabel createContent() {
    for(String post : writing.getPostContent()) {
      postContent = new JLabel(post);
      this.add(postContent);
    }
    postContent.setBounds(10,10,700,600);

    return postContent;
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
}
